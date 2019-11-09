package com.cryptomip;

import com.baseTool.util.CookieUtil;
import com.cryptomip.Differential.trunkDif.DifferentTrunkAnalysisControll;
import com.cryptomip.activeMq.PromoteActConsumer;
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

    @RequestMapping("linerChoose")
    public String linerChoose() {
        return "linerChoose";
    }

    @RequestMapping("idChoose")
    public String idChoose() {
        return "idChoose";
    }

    @RequestMapping("zeroChoose")
    public String zeroChoose() {
        return "zeroChoose";
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
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "TrunkId";
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);

        if (cookie != null) {

            model.addAttribute("htmlId", session.getAttribute(cookie.getName() + "TrunkId"));
            model.addAttribute("compileTrunkId", session.getAttribute(cookie.getName() + "ResId"));
        }
        return "impossible";
    }

    @RequestMapping("impossibleBit")
    public String impossibleBit(Model model, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "BitId";
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);

        if (cookie != null) {

            model.addAttribute("htmlBitId", session.getAttribute(cookie.getName() + "BitId"));
            model.addAttribute("compileBitId", session.getAttribute(cookie.getName() + "ResBitId"));
        }
        return "impossibleBit";
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

    @RequestMapping("linerBit")
    public String linerBit(Model model, HttpServletRequest request) {
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "linearBit";
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null){

            model.addAttribute("html", session.getAttribute(cookie.getName()+"BitLinear"));
            model.addAttribute("compileResBitLinear", session.getAttribute(cookie.getName() + "ResBitLinear"));
        }
        return "linerBit";
    }

    @RequestMapping("base")
    public String base(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "trunkBase";
        if (cookie != null){

            model.addAttribute("htmlBase", session.getAttribute(cookie.getName()+"TrunkBase"));
            model.addAttribute("compileResTrunkBase", session.getAttribute(cookie.getName() + "ResTrunkBase"));
        }
        return "base";
    }

    @RequestMapping("zero")
    public String zero(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "trunkZero";
        if (cookie != null){

            model.addAttribute("htmlZero", session.getAttribute(cookie.getName()+"TrunkZero"));
            model.addAttribute("compileResTrunkZero", session.getAttribute(cookie.getName() + "ResTrunkZero"));
        }
        return "zero";
    }

    @RequestMapping("zeroBit")
    public String zeroBit(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        PromoteActConsumer.ip = DifferentTrunkAnalysisControll.getIp(request);
        PromoteActConsumer.analysisType = "bitZero";
        if (cookie != null){

            model.addAttribute("htmlZeroBit", session.getAttribute(cookie.getName()+"BitZero"));
            model.addAttribute("compileResBitZero", session.getAttribute(cookie.getName() + "ResBitZero"));
        }
        return "zeroBit";
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
