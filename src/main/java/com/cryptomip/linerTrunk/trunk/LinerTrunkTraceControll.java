package com.cryptomip.linerTrunk.trunk;

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
public class LinerTrunkTraceControll {
    @Autowired
    private LInerTrunkDirService lInerTrunkDirService;

    @Autowired
    private LinerTrunkTraceService linerTrunkTraceService;

    @Value("${liner.sol.trunk.path}")
    private String solFilePath;

    public static int traceInt;

    @RequestMapping("linerTrunk/trace")
    public String differentTrace(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (subTxt != null && cookie != null)
            session.setAttribute(cookie.getName()+"TrunkLinear", subTxt);
        session.setAttribute(cookie.getName()+"ResTrunkLinear",compileRes);
        if (cookie != null && session.getAttribute(cookie.getName()+"TrunkLinear") != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()+"TrunkLinear"));
        return "linerTrunkTrace";
    }

    @RequestMapping("linerTrace/getTrace")
    @ResponseBody
    public Message getTrace() {
        List<String> fileList = lInerTrunkDirService.getFileName(solFilePath);
        if (fileList.size() == 0 && traceInt == 0) {
            traceInt = 1;
            return Message.fail("405");
        }
        if (fileList.size() == 0 && traceInt == 1) {
            return Message.fail("410");
        }

        HashMap<String, String> trace = linerTrunkTraceService.getTrace(fileList,solFilePath);
        if(trace==null){
            return Message.fail("410");
        }
        traceInt = 0;
        return Message.success(trace);
    }
}
