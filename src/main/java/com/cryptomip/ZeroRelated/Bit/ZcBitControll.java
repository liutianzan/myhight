package com.cryptomip.ZeroRelated.Bit;

import com.baseTool.pojo.Message;
import com.baseTool.util.CookieUtil;
import com.cryptomip.Differential.trunkDif.DifferentTrunkAnalysisControll;
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
public class ZcBitControll {
    @Autowired
    private ZcBitService zcBitService;

    public static boolean isZeroCompile;

    public static int finsishComplie;

    @RequestMapping("zcBit/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "bitZero";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            DifferentTrunkAnalysisControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName() + "BitZero") + "";
            if (html != null && html.equals(subTxt) && !html.equals("null")) {
                return "已编译";
            }
            if ("".equals(subTxt)) return "";
            String s = zcBitService.saveText(subTxt);
            html = subTxt;
            session.setAttribute(cookie.getName()+ "BitZero", html);
            model.addAttribute("htmlZeroBit", subTxt);
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

    @RequestMapping("zcBit/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        Object html = null;
        if (cookie != null) {
            html = session.getAttribute(cookie.getName() + "BitZero");
        }
        if (html == null || (!subTxt.equals(html) &&
                !html.toString().replace("\r", "").equals(subTxt)))
            isZeroCompile = false;
        if (isZeroCompile == false) return "编译未成功";
        try {
//            zcBitService.removeSolFile();
//            finsishComplie = 1;
            zcBitService.complieProject();
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

    @RequestMapping("/getZcBitCompileStatus")
    @ResponseBody
    public Message getComplieStatus() {
        String result = zcBitService.getCompileContent();
        return Message.customize(finsishComplie + "", result);
    }
}
