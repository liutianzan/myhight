package com.cryptomip.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         Object loginName = request.getSession().getAttribute("loginName");
         if (null == loginName || !(loginName instanceof String)) {
             // 未登录，重定向到登录页
             response.sendRedirect(request.getContextPath()+"/login");
             return false;
         }
         String userName = (String) loginName;
         System.out.println("当前用户已登录，登录的用户名为： " + userName);
         return true;
    }
}
