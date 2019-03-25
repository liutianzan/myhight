package com;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("differentMq");
    }

    @Bean  //一定要加，不然这个方法不会运行
    public ServletRegistrationBean getServletRegistrationBean() {  //一定要返回ServletRegistrationBean
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet());     //放入自己的Servlet对象实例
        bean.addUrlMappings("/secondServlet");  //访问路径值
        return bean;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
