package com.cryptomip;

import com.baseTool.util.CookieUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class LinkIndex {
    @RequestMapping("login")
    public String login() {

        return "login";
    }

    @RequestMapping("middle")
    public String middle(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        model.addAttribute("html", session.getAttribute(userName));
        return "middle";
    }

    @RequestMapping("choose")
    public String choose(String subTxt, String compileRes, String typeHtml, String typeRes, Model model, HttpServletResponse response, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        if (subTxt != null) {
            session.setAttribute(userName + typeHtml, subTxt);
            session.setAttribute(userName + typeRes, compileRes);
        }

        String token = UUID.randomUUID().toString().replace("-", "");

        return "choose";
    }

    @RequestMapping("differentChoose")
    public String diffChoose() {
        return "differentChoose";
    }

    @RequestMapping("dif/Truncated")
    public String different(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);


        model.addAttribute("html", session.getAttribute(userName + "trunkDiff"));
        model.addAttribute("compileRes", session.getAttribute(userName + "Res"));
        return "different";
    }

    @RequestMapping("dif/bit")
    public String bitDifferrnt(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);

        model.addAttribute("html", session.getAttribute(userName + "DifBIt"));
        model.addAttribute("compileResDifBIt", session.getAttribute(userName + "ResDifBIt"));
        return "bitDifferent";
    }

    @RequestMapping("impossible")
    public String impossible(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        model.addAttribute("htmlId", session.getAttribute(userName + "DifId"));
        return "impossible";
    }

    @RequestMapping("liner")
    public String liner(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);

        model.addAttribute("html", session.getAttribute(userName + "TrunkLinear"));
        model.addAttribute("compileResTrunkLinear", session.getAttribute(userName + "ResTrunkLinear"));
        return "liner";
    }

    @RequestMapping("base")
    public String base(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        model.addAttribute("html", session.getAttribute(userName + "divsion"));
        return "base";
    }

    @RequestMapping("zero")
    public String zero(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        model.addAttribute("html", session.getAttribute(userName + "TrunkZero"));
        return "zero";
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
