package com.cryptomip.Differential.trunkDif;

import com.baseTool.pojo.Message;
import com.baseTool.util.CookieUtil;
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
public class DifferentTrunkTraceControll {
    @Autowired
    private DifferentTrunkTraceService traceService;

    @Autowired
    private DifferentTrunkDirService dirService;

    @Value("${sol.trunkdif.file.path}")
    private String solFilePath;

    public static int traceInt = 0;

    @RequestMapping("different/differentTrace")
    public String differentTrace(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        String userName = CookieUtil.getUserName(session);
        if (subTxt != null && cookie != null){
            session.setAttribute(userName+"trunkDiff", subTxt);
            session.setAttribute(userName+"Res",compileRes);
        }

        if (cookie != null && session.getAttribute(userName+"trunkDiff") != null)
            model.addAttribute("html", session.getAttribute(userName+"trunkDiff"));
        return "differentialTrace";
    }

    @RequestMapping("different/getTrace")
    @ResponseBody
    public Message getTrace(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        List<String> fileList = dirService.getFileName(solFilePath+userName+"/");
        if (fileList.size() == 0 && traceInt == 0) {
            traceInt = 1;
            return Message.fail("405");
        }
        if (fileList.size() == 0 && traceInt == 1) {
            return Message.fail("410");
        }

        HashMap<String, String> trace = traceService.getTrace(fileList,solFilePath+userName+"/");
        if (trace == null) {
            return Message.fail("410");
        }
        traceInt = 0;
        return Message.success(trace);
    }
}
