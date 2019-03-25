package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class DirController {
    public static int dif = 0;

    @Autowired
    private DirService dirServiceImp;

    @Value("${sol.file.path}")
    private String solFilePath;

    @RequestMapping("/diffDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {
        String projectName = request.getContextPath();
        String res = dirServiceImp.getDir(projectName);
        return res;
    }

    @RequestMapping("/getFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {

        String content = dirServiceImp.getContent(filename);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "dirContent";
    }

    @RequestMapping("/getplain")
    public String getDiff(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));

        return "dirContent";
    }

    @RequestMapping("differentPath")
    public String differentPath(String subTxt, String compileRes,Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(subTxt!=null&&cookie!=null){

            session.setAttribute(cookie.getName(), subTxt);
            session.setAttribute(cookie.getName()+"Res",compileRes);
        }
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "differentDir";
    }


    @RequestMapping("removeSol")
    @ResponseBody
    public String removeFile() {
        String res = null;
        try {
            List<String> fileList = dirServiceImp.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            dirServiceImp.removeSolFile();
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }

    public String testJsp() {
        return "dirContent";
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}