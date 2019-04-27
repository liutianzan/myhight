package com.cryptomip.Differential.Bit;

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
public class BitDiffernetControll {
    @Autowired
    private BitDifferentService bitDifferentService;

    public static boolean isCompile;

    public static int finsishComplie = 0;

    /**
     * 编译
     * */
    @RequestMapping("bit/submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "bitDif";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            String userName = CookieUtil.getUserName(session);
            DifferentTrunkAnalysisControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(userName+"DifBIt")+"";
            if(html!=null&&html.equals(subTxt)&&!html.equals("null")){
                return "已编译";
            }
            if("".equals(subTxt))return "";
            String s = bitDifferentService.saveText(subTxt,userName);
            html = subTxt;
            if(cookie!=null)
            session.setAttribute(userName+"DifBIt",html);
            model.addAttribute("html",subTxt);
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

    /**
     * 分析
     * */
    @RequestMapping("bit/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        String userName = CookieUtil.getUserName(session);
        Object html = null;
        if(cookie!=null){
            html = session.getAttribute(userName+"DifBIt");
        }
        if(html==null||(!subTxt.equals(html)&&
                !html.toString().replace("\r","").equals(subTxt)))
            isCompile = false;
        if(isCompile==false)return "编译未成功";
        try {
//            bitDifferentService.removeSolFile();
//            finsishComplie = 1;
            bitDifferentService.complieProject(userName);
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
