package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DirController {
    public static int dif = 0;

    @Autowired
    private DirServiceImp dirServiceImp;

    @RequestMapping("/diffDir")
    @ResponseBody
    public String getDiffDir(){

        String res = dirServiceImp.getDir();
        return res;
    }
}