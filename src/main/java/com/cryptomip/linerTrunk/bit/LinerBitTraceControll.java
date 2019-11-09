package com.cryptomip.linerTrunk.bit;

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
public class LinerBitTraceControll {
    @Autowired
    private LInerBitDirService lInerBitDirService;

    @Autowired
    private LinerBitTraceService linerBitTraceService;

    @Value("${linerBit.sol.trunk.path}")
    private String solFilePath;

    public static int traceInt;

    @RequestMapping("linerBit/trace")
    public String differentTrace(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (subTxt != null && cookie != null)
            session.setAttribute(cookie.getName()+"BitLinear", subTxt);
        session.setAttribute(cookie.getName()+"ResBitLinear",compileRes);
        if (cookie != null && session.getAttribute(cookie.getName()+"BitLinear") != null)
            model.addAttribute("htmlLinerBit", session.getAttribute(cookie.getName()+"BitLinear"));
        return "linerBitTrace";
    }

    @RequestMapping("linerBitTrace/getTrace")
    @ResponseBody
    public Message getTrace() {
        List<String> fileList = lInerBitDirService.getFileName(solFilePath);
        if (fileList.size() == 0 && traceInt == 0) {
            traceInt = 1;
            return Message.fail("405");
        }
        if (fileList.size() == 0 && traceInt == 1) {
            return Message.fail("410");
        }

        HashMap<String, String> trace = linerBitTraceService.getTrace(fileList,solFilePath);
        if(trace==null){
            return Message.fail("410");
        }
        traceInt = 0;
        return Message.success(trace);
    }
}
