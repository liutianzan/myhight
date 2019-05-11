package com.cryptomip.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControll {
    @Autowired
    private LoginService loginService;
    @RequestMapping("isLogin")
    public String login(HttpServletRequest request, String username, String password, Model model){
        String mgs = loginService.isLogin(username,password);
        if(!mgs.equals("")){
            model.addAttribute("mgs",mgs);
            return "login";
        }
        request.getSession().setAttribute("loginName",username);
        return "redirect:/choose";
    }
    @RequestMapping("loginout")
    public String loginout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
