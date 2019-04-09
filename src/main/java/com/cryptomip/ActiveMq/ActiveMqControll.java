package com.cryptomip.ActiveMq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ActiveMqControll {
    @RequestMapping("receive")
    public String getMq(HttpServletRequest req, HttpServletResponse resp) {


        return "receive";
    }
}
