package com.cryptomip.divsion;

import com.baseTool.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class DivsionDirControll {
    @Autowired
    private DivsionDirService divsionDirService;

    @Value("${div.sol.file.path}")
    private String solFilePath;


    @RequestMapping("/divsionDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String projectName = request.getContextPath();
        String res = divsionDirService.getDir(projectName, userName);
        return res;
    }

    @RequestMapping("divsionPath")
    public String differentPath(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);

        if (subTxt != null)
            session.setAttribute(userName + "divsion", subTxt);
        session.setAttribute(userName + "ResDifDiv", compileRes);
        model.addAttribute("html", session.getAttribute(userName + "divsion"));
        return "basePath";
    }

    @RequestMapping("/getDivsionFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String content = divsionDirService.getContent(filename, userName);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        List<String> res = divsionDirService.getFileChoose("", userName);
        model.addAttribute("fileNameList", res);
        model.addAttribute("html", session.getAttribute(userName + "divsion"));
        return "baseContent";
    }

    @RequestMapping("removeDivsionSol")
    @ResponseBody
    public String removeFile(HttpServletRequest request) {
        String res = null;
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        try {
            List<String> fileList = divsionDirService.getFileName(solFilePath + userName + "/");
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            divsionDirService.removeSolFile(userName);
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
