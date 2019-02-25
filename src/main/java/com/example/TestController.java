package com.example;

import com.com.test.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("choose")
    public String choose() {
        return "choose";
    }

    @RequestMapping("edi")
    public String mytest() {
        return "editor1";
    }

    @RequestMapping("different")
    public String different() {
        return "different";
    }

    @RequestMapping("impossible")
    public String impossible() {
        return "impossible";
    }

    @RequestMapping("liner")
    public String liner() {
        return "liner";
    }

    @RequestMapping("base")
    public String base() {
        return "base";
    }

    @RequestMapping("zero")
    public String zero() {
        return "zero";
    }

    @RequestMapping("submit/text")
    @ResponseBody
    public String subText(String subTxt) throws Exception {
        try {
            if("".equals(subTxt))return "";
            String s = testService.saveText(subTxt);
            if ("".equals(s)) {
                return "编译失败";
            }
            return s;
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
