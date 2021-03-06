package com.cryptomip.impossibleDifferent.trunk;

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
public class ImpossibleDifControll {
    @Autowired
    private ImpossibleDiffService impossibleDiffService;

    public static boolean isCompile;

    public static int finsishComplie;

    @RequestMapping("ibTrunk/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "TrunkId";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            DifferentTrunkAnalysisControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName()+"TrunkId") + "";
            if (html != null && html.equals(subTxt) && !html.equals("null")) {
                return "已编译";
            }
            if ("".equals(subTxt)) return "";
            String s = impossibleDiffService.saveText(subTxt);
            html = subTxt;
            if (cookie != null)
                session.setAttribute(cookie.getName()+"TrunkId", html);
            model.addAttribute("htmlId", subTxt);
//            model.addAttribute("htmlCode",html);
            if ("".equals(s)) {
                isCompile = false;
                return "编译失败";
            }
            isCompile = true;
            return "编译成功";
        } catch (Exception e) {

            e.printStackTrace();

        }
        return "错误";
    }

    @RequestMapping("ibTrunk/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        Object html = null;
        if (cookie != null) {
            html = session.getAttribute(cookie.getName()+"TrunkId");
        }
        if (html == null || (!subTxt.equals(html) &&
                !html.toString().replace("\r", "").equals(subTxt)))
            isCompile = false;
        if (isCompile == false) return "编译未成功";
        try {
//            impossibleDiffService.removeSolFile();
//            finsishComplie = 1;
            impossibleDiffService.complieProject();
//            finsishComplie = 2;
//            if("".equals(result))return "分析失败";
//            if(cookie!=null){
//                session.setAttribute(cookie.getName()+"com",result);
//            }
//            return result;
            return "编译成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "分析失败";
        }

    }

    @RequestMapping("/getIbComplieStatus")
    @ResponseBody
    public Message getComplieStatus() {
        String result = impossibleDiffService.getCompileContent();
        return Message.customize(finsishComplie + "", result);
    }
}
