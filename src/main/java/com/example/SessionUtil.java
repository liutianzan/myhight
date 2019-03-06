package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static void setSession(String key, Object value, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(key,value);
    }
}
