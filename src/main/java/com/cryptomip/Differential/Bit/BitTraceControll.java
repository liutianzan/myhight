package com.cryptomip.Differential.Bit;

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
public class BitTraceControll {

    @Autowired
    private BitDirService bitDirService;

    @Autowired
    private BitTraceService bitTraceService;

    @Value("${bit.sol,file.path}")
    private String solFilePath;

    public static int traceInt;

    @RequestMapping("bitDiff/differentTrace")
    public String differentTrace(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        if (subTxt != null )
            session.setAttribute(userName+"DifBIt", subTxt);
        session.setAttribute(userName + "ResDifBIt", compileRes);
        if ( session.getAttribute(userName+"DifBIt") != null)
            model.addAttribute("html", session.getAttribute(userName+"DifBIt"));
        return "bitDifferentialTrace";
    }

    @RequestMapping("bitDiff/getTrace")
    @ResponseBody
    public Message getTrace(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        List<String> fileList = bitDirService.getFileName(solFilePath+userName+"/");
        if (fileList.size() == 0 && traceInt == 0) {
            traceInt = 1;
            return Message.fail("405");
        }
        if (fileList.size() == 0 && traceInt == 1) {
            return Message.fail("410");
        }

        HashMap<String, String> trace = bitTraceService.getTrace(fileList, solFilePath+userName+"/");
        if (trace == null) {
            return Message.fail("410");
        }
        traceInt = 0;
        return Message.success(trace);
    }
}
