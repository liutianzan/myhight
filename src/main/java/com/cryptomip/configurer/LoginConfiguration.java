package com.cryptomip.configurer;

import com.cryptomip.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**/choose");
        loginRegistry.addPathPatterns("/**/differentChoose");
        loginRegistry.addPathPatterns("/**/dif/Truncated");
        loginRegistry.addPathPatterns("/**/differentPath");
        loginRegistry.addPathPatterns("/**/different/differentTrace");


        // 排除路径
//        loginRegistry.excludePathPatterns("/");
//        loginRegistry.excludePathPatterns("/login");
//        loginRegistry.excludePathPatterns("/loginout");
//        // 排除资源请求
//        loginRegistry.excludePathPatterns("/css/*.css");
//        loginRegistry.excludePathPatterns("/myJs/*.js");
//        loginRegistry.excludePathPatterns("/myPicture/*.png");
//        loginRegistry.excludePathPatterns("/myPicture/*.jpg");
//        loginRegistry.excludePathPatterns("/src/**");
//        loginRegistry.excludePathPatterns("/src-min-noconflict/**");
    }

}
