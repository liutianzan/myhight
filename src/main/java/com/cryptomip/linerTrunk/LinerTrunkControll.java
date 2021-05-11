package com.cryptomip.linerTrunk;

import com.baseTool.pojo.Message;
import com.cryptomip.activeMq.PromoteActConsumer;
import com.cryptomip.Differential.trunkDif.DifferentTrunkAnalysisControll;
import com.baseTool.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LinerTrunkControll {
    @Autowired
    private linerTrunkService linerTrunkService;

    public static boolean isCompile;

    public static int finsishComplie;

    @RequestMapping("linerTrunk/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "linearTrunk";
            HttpSession session = request.getSession();
            String userName = CookieUtil.getUserName(session);
            DifferentTrunkAnalysisControll.finsishComplie = 0;
            String html = null;
                html = session.getAttribute(userName+"TrunkLinear") + "";
            if (html != null && html.equals(subTxt) && !html.equals("null")&&isCompile==true) {
                return "已编译";
            }
            if ("".equals(subTxt)) return "";
            String s = linerTrunkService.saveText(subTxt,userName);
            html = subTxt;
            session.setAttribute(userName+"TrunkLinear", html);
            model.addAttribute("html", subTxt);
//            model.addAttribute("htmlCode",html);
//            if ("".equals(s)) {
//                isCompile = false;
//                return "编译失败";
//            }
            isCompile = true;
            return "编译成功";
        } catch (Exception e) {

            e.printStackTrace();

        }
        return "错误";
    }

    @RequestMapping("linerTrunk/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        Object html = null;
            html = session.getAttribute(userName+"TrunkLinear");
        if (html == null || (!subTxt.equals(html) &&
                !html.toString().replace("\r", "").equals(subTxt)))
            isCompile = false;
        if (isCompile == false) return "编译未成功";
        try {
//            linerTrunkService.removeSolFile();
//            finsishComplie = 1;
            linerTrunkService.complieProject(userName);
//            finsishComplie = 2;
//            if("".equals(result))return "分析失败";
//            if(cookie!=null){
//                session.setAttribute(cookie.getName()+"com",result);
//            }
            return "编译成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "分析失败";
        }

    }

    @RequestMapping("/getLinerTrunkCompileStatus")
    @ResponseBody
    public Message getComplieStatus(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String result = linerTrunkService.getCompileContent(userName);
        return Message.customize(finsishComplie + "", result);
    }
}
