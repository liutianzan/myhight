package com.cryptomip.Differential.Bit;

import com.baseTool.pojo.Message;
import com.cryptomip.ActiveMq.PromoteActConsumer;
import com.cryptomip.Differential.trunkDif.ComplieControll;
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
public class BitDiffernetControll {
    @Autowired
    private BitDifferentService bitDifferentService;

    public static boolean isCompile;

    public static int finsishComplie = 0;

    @RequestMapping("bit/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "bitDif";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            ComplieControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName()+"DifBIt")+"";
            if(html!=null&&html.equals(subTxt)&&!html.equals("null")){
                return "已编译";
            }
            if("".equals(subTxt))return "";
            String s = bitDifferentService.saveText(subTxt);
            html = subTxt;
            if(cookie!=null)
            session.setAttribute(cookie.getName()+"DifBIt",html);
            model.addAttribute("html",subTxt);
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

    @RequestMapping("bit/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = ComplieControll.getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        Object html = null;
        if(cookie!=null){
            html = session.getAttribute(cookie.getName()+"DifBIt");
        }
        if(html==null||(!subTxt.equals(html)&&
                !html.toString().replace("\r","").equals(subTxt)))
            isCompile = false;
        if(isCompile==false)return "编译未成功";
        try {
//            bitDifferentService.removeSolFile();
//            finsishComplie = 1;
            bitDifferentService.complieProject();
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
    @RequestMapping("/getBiteDifferentCompileStatus")
    @ResponseBody
    public Message getComplieStatus(){
        String result = bitDifferentService.getCompileContent();
        return Message.customize(finsishComplie+"",result);
    }
}
