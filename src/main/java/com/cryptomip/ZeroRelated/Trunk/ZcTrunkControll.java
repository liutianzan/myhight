package com.cryptomip.ZeroRelated.Trunk;

import com.baseTool.pojo.Message;
import com.cryptomip.Differential.trunkDif.DifferentTrunkAnalysisControll;
import com.baseTool.util.CookieUtil;
import com.cryptomip.activeMq.PromoteActConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ZcTrunkControll {
    @Autowired
    private ZcTrunkService zcTrunkService;

    public static boolean isZeroCompile;

    public static int finsishComplie;

    @RequestMapping("zcTrunk/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "trunkZero";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            DifferentTrunkAnalysisControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName() + "TrunkZero") + "";
            if (html != null && html.equals(subTxt) && !html.equals("null")) {
                return "已编译";
            }
            if ("".equals(subTxt)) return "";
            String s = zcTrunkService.saveText(subTxt);
            html = subTxt;
            session.setAttribute(cookie.getName()+ "TrunkZero", html);
            model.addAttribute("htmlZero", subTxt);
//            model.addAttribute("htmlCode",html);
            if ("".equals(s)) {
                isZeroCompile = false;
                return "编译失败";
            }
            isZeroCompile = true;
            return "编译成功";
        } catch (Exception e) {

            e.printStackTrace();

        }
        return "错误";
    }

    @RequestMapping("zcTrunk/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        Object html = null;
        if (cookie != null) {
            html = session.getAttribute(cookie.getName() + "TrunkZero");
        }
        if (html == null || (!subTxt.equals(html) &&
                !html.toString().replace("\r", "").equals(subTxt)))
            isZeroCompile = false;
        if (isZeroCompile == false) return "编译未成功";
        try {
//            zcTrunkService.removeSolFile();
//            finsishComplie = 1;
            zcTrunkService.complieProject();
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

    @RequestMapping("/getZcTrunkCompileStatus")
    @ResponseBody
    public Message getComplieStatus() {
        String result = zcTrunkService.getCompileContent();
        return Message.customize(finsishComplie + "", result);
    }
}
