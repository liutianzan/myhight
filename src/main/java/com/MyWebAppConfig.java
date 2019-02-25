package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${test.path.name}")
    private String uploadFolder;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static").addResourceLocations("classpath:/static");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/picture/**").addResourceLocations("file:/Users/yueliu/Desktop/test1/picture/");
        super.addResourceHandlers(registry);
    }
}