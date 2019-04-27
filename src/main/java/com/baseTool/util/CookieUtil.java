package com.baseTool.util;

import com.cryptomip.configurer.ConStants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieUtil {
    public static Cookie getToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies!=null)
        for(int i = 0;i<cookies.length;i++){
            if(cookies[i].getName().equals("token")){
                cookie = cookies[i];
            }
        }
        return cookie;
    }

    public static String getUserName(HttpSession session){
        String userName = (String) session.getAttribute(ConStants.USER_NAME);
        return userName;
    }
}
