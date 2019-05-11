package com.cryptomip.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.MarshalledObject;

@Controller
public class RegisterControll {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("register")
    public String register(){
        return "register";
    }
    @RequestMapping("success")
    public String registerSuccess(){
        return "success";
    }
    @RequestMapping("registering")
    public String comRegister(String username, String password, Model model){
        String mgs = registerService.insertTuser(username,password);
        if(!mgs.equals("")){
            model.addAttribute("registerError",mgs);
        }
        model.addAttribute("name",username);
        return "success";
    }
}
