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
        String projectName = request.getContextPath();
        String res = divsionDirService.getDir(projectName);
        return res;
    }

    @RequestMapping("divsionPath")
    public String differentPath(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (subTxt != null && cookie != null) {
            session.setAttribute(cookie.getName() + "TrunkBase", subTxt);
            session.setAttribute(cookie.getName() + "ResTrunkBase", compileRes);
        }
        if (cookie != null)
            model.addAttribute("htmlBase", session.getAttribute(cookie.getName()));
        return "basePath";
    }

    @RequestMapping("/getDivsionFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {

        String content = divsionDirService.getContent(filename);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        List<String> res = divsionDirService.getFileChoose("");
        model.addAttribute("fileNameList", res);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("htmlBase", session.getAttribute(cookie.getName()));
        return "baseContent";
    }

    @RequestMapping("removeDivsionSol")
    @ResponseBody
    public String removeFile() {
        String res = null;
        try {
            List<String> fileList = divsionDirService.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            divsionDirService.removeSolFile();
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
