package com.example.Differential.trunkDif;

import com.example.ActiveMq.PromoteActConsumer;
import com.example.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DifferentTrunkController {

    @Autowired
    private DifferentTrunkService testService;



    public static boolean isCompile = false;


    @RequestMapping("submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model, HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType = "trunkDif";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            ComplieControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName() + "trunkDiff") + "";
            if (html != null && html.equals(subTxt) && !html.equals("null")&&isCompile==true) {
                return "已编译";
            }
            if ("".equals(subTxt)) return "";
            String s = testService.saveText(subTxt);
            html = subTxt;
            if (cookie != null)
                session.setAttribute(cookie.getName() + "trunkDiff", html);
            model.addAttribute("html", subTxt);
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


}