package com.example;

import com.com.test.pojo.Message;
import com.example.ActiveMq.PromoteActConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
public class ComplieControll {
    @Autowired
    private TestService testService;

    @Autowired
    private DirService dirService;

    public static int finsishComplie = 0;

    @RequestMapping("/complie")
    @ResponseBody
    public String compile(String subTxt, HttpServletRequest request) {
        PromoteActConsumer.ip = getIp(request);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        Object html = null;
        if(cookie!=null){
            html = session.getAttribute(cookie.getName());
        }
        if(html==null||(!subTxt.equals(html)&&
                !html.toString().replace("\r","").equals(subTxt)))
            TestController.isCompile = false;
        if(TestController.isCompile==false)return "编译未成功";
        // TODO
        try {
        testService.complieProject();
//            dirService.removeSolFile();
//            finsishComplie = 1;
//            String result = testService.complieProject();
//            finsishComplie = 2;
//            if("".equals(result))return "分析失败";
//            if(cookie!=null){
//                session.setAttribute(cookie.getName()+"com",result);
//            }
//            return result;
            return "编译成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "分析失败";
        }

    }
    @RequestMapping("/getComplieStatus")
    @ResponseBody
    public Message getComplieStatus(String compileRes, HttpServletRequest request, HttpServletResponse response){

        String result = testService.getCompileContent();
        return Message.customize(finsishComplie+"",result);
    }
    public static String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        System.out.println(ip+"dsadsadsadsa");
        return ip;
    }
}
