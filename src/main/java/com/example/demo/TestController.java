package com.example.demo;

import com.com.test.pojo.Message;
import com.example.demo.com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("res")
    public String mytest(){
        return "editor1";
    }
    @RequestMapping("submit/text")
    @ResponseBody
    public Object subText(String subTxt) throws Exception {
        try {
            Object s = testService.saveText(subTxt);
            return Message.success(s);
        }catch (Exception e){

            return Message.fail("403");
        }

    }
}
