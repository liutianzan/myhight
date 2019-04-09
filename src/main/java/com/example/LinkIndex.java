package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "middle";
    }

    @RequestMapping("choose")
    public String choose(Model model, HttpServletResponse response, HttpServletRequest request) {
        String token = UUID.randomUUID().toString().replace("-", "");
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(10000000); //存活期为100000秒
        response.addCookie(cookie);

        return "choose";
    }

    @RequestMapping("differentChoose")
    public String diffChoose() {
        return "differentChoose";
    }

    @RequestMapping("dif/Truncated")
    public String different(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("token")) {
                cookie = cookies[i];
            }
        }
        if (cookie != null) {

            model.addAttribute("html", session.getAttribute(cookie.getName() + "trunkDiff"));
            model.addAttribute("compileRes", session.getAttribute(cookie.getName() + "Res"));
        }
        return "different";
    }

    @RequestMapping("dif/bit")
    public String bitDifferrnt(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null) {

            model.addAttribute("html", session.getAttribute(cookie.getName() + "DifBIt"));
            model.addAttribute("compileResDifBIt", session.getAttribute(cookie.getName() + "ResDifBIt"));
        }
        return "bitDifferent";
    }

    @RequestMapping("impossible")
    public String impossible(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "impossible";
    }

    @RequestMapping("liner")
    public String liner(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null){

            model.addAttribute("html", session.getAttribute(cookie.getName()+"TrunkLinear"));
            model.addAttribute("compileResTrunkLinear", session.getAttribute(cookie.getName() + "ResTrunkLinear"));
        }
        return "liner";
    }

    @RequestMapping("base")
    public String base(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "base";
    }

    @RequestMapping("zero")
    public String zero(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "zero";
    }
}
