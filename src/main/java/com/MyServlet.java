package com;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType(getServletContext().getInitParameter("content"));
        //进入异步模式,调用业务处理线程进行业务处理
        //Servlet不会被阻塞,而是直接往下执行
        //业务处理完成后的回应由AsyncContext管理
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(900000000);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType(getServletContext().getInitParameter("content"));
        //进入异步模式,调用业务处理线程进行业务处理
        //Servlet不会被阻塞,而是直接往下执行
        //业务处理完成后的回应由AsyncContext管理
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(900000000);
    }
}

