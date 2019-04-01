package com.example;

import com.com.test.pojo.Message;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class TraceControll {
    @Autowired
    private TraceService traceService;

    @Autowired
    private DirService dirService;

    @Value("${sol.file.path}")
    private String solFilePath;

    public static int traceInt = 0;

    @RequestMapping("different/differentTrace")
    public String differentTrace(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (subTxt != null && cookie != null)
            session.setAttribute(cookie.getName()+"trunkDiff", subTxt);
        session.setAttribute(cookie.getName()+"Res",compileRes);
        if (cookie != null && session.getAttribute(cookie.getName()) != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()+"trunkDiff"));
        return "differentialTrace";
    }

    @RequestMapping("different/getTrace")
    @ResponseBody
    public Message getTrace() {
        List<String> fileList = dirService.getFileName(solFilePath);
        if (fileList.size() == 0 && traceInt == 0) {
            traceInt = 1;
            return Message.fail("405");
        }
        if (fileList.size() == 0 && traceInt == 1) {
            return Message.fail("410");
        }

        HashMap<String, String> trace = traceService.getTrace(fileList);
        if (trace == null) {
            return Message.fail("410");
        }
        traceInt = 0;
        return Message.success(trace);
    }
}
