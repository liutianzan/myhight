package com.example;

import com.com.test.pojo.Message;
import com.example.ActiveMq.PromoteActConsumer;
import org.python.antlr.op.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("login")
    public String login() {

        return "login";
    }
    @RequestMapping("middle")
    public String middle(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
            model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "middle";
    }

    @RequestMapping("choose")
    public String choose(Model model,HttpServletResponse response,HttpServletRequest request) {
        String token = UUID.randomUUID().toString().replace("-", "");
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(1000); //存活期为10秒
        response.addCookie(cookie);

        return "choose";
    }
    @RequestMapping("isLogin")
    public String login(String username,String password,Model model){

        return "1";
    }

    @RequestMapping("edi")
    public String mytest() {
        return "editor1";
    }

    @RequestMapping("differentChoose")
    public String diffChoose(){
        return "differentChoose";
    }

    @RequestMapping("dif/Truncated")
    public String different(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for(int i = 0;i<cookies.length;i++){
            if(cookies[i].getName().equals("token")){
                cookie = cookies[i];
            }
        }
        if(cookie!=null){

            model.addAttribute("html",session.getAttribute(cookie.getName()));
            model.addAttribute("compileRes",session.getAttribute(cookie.getName()+"Res"));
        }
        return "different";
    }
    @RequestMapping("dif/bit")
    public String bitDifferrnt(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
        model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "bitDifferent";
    }

    @RequestMapping("impossible")
    public String impossible(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
            model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "impossible";
    }

    @RequestMapping("liner")
    public String liner(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
            model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "liner";
    }

    @RequestMapping("base")
    public String base(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
            model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "base";
    }

    @RequestMapping("zero")
    public String zero(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(cookie!=null)
            model.addAttribute("html",session.getAttribute(cookie.getName()));
        return "zero";
    }

    public static boolean isCompile = false;


    @RequestMapping("submit/text")
    @ResponseBody
    public String subText(String subTxt, Model model,HttpServletRequest request) throws Exception {
        try {
            PromoteActConsumer.analysisType="trunkDif";
            HttpSession session = request.getSession();
            Cookie cookie = CookieUtil.getToken(request);
            ComplieControll.finsishComplie = 0;
            String html = null;
            if (cookie != null)
                html = session.getAttribute(cookie.getName())+"";
            if(html!=null&&html.equals(subTxt)&&!html.equals("null")){
                return "已编译";
            }
            if("".equals(subTxt))return "";
            String s = testService.saveText(subTxt);
            html = subTxt;
            if(cookie!=null)
            session.setAttribute(cookie.getName(),html);
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

    @RequestMapping("testFun")
    public String test() {
        return "AddAndMul";
    }

    @RequestMapping("testA")
    @ResponseBody
    public String buttonA(String subText) throws IOException, InterruptedException {
        String s = testService.buttonA(subText);
        return s;
    }

    @RequestMapping("testB")
    @ResponseBody
    public Object buttonB(String subText) throws IOException, InterruptedException {
        Object s = testService.buttonB(subText);
        return s;
    }
}