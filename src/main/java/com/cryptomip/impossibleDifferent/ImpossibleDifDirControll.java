package com.cryptomip.impossibleDifferent;

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
public class ImpossibleDifDirControll {
    @Autowired
    private ImpossibleIbDirService impossibleIbDirService;

    @Value("${trunkId.sol.file.path}")
    private String solFilePath;


    @RequestMapping("/ibTrunkDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {
        String projectName = request.getContextPath();
        String res = impossibleIbDirService.getDir(projectName);
        return res;
    }

    @RequestMapping("ibTrunkPath")
    public String differentPath(String subTxt, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(subTxt!=null&&cookie!=null)
            session.setAttribute(cookie.getName(), subTxt);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "Impossible/impossiblePath";
    }

    @RequestMapping("/getibTrunkFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {

        String content = impossibleIbDirService.getContent(filename);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()));
        return "Impossible/impossibleContent";
    }

    @RequestMapping("removeibTrunkSol")
    @ResponseBody
    public String removeFile() {
        String res = null;
        try {
            List<String> fileList = impossibleIbDirService.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            impossibleIbDirService.removeSolFile();
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
