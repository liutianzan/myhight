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
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String projectName = request.getContextPath();
        String res = impossibleIbDirService.getDir(projectName, userName);
        return res;
    }

    @RequestMapping("ibTrunkPath")
    public String differentPath(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        if (subTxt != null )
            session.setAttribute(userName+"DifId", subTxt);
        session.setAttribute(userName + "ResDifId", compileRes);
            model.addAttribute("htmlId", session.getAttribute(userName+"DifId"));
        return "impossiblePath";
    }

    @RequestMapping("/getibTrunkFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String content = impossibleIbDirService.getContent(filename, userName);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        List<String> res = impossibleIbDirService.getFileChoose("", userName);
        model.addAttribute("fileNameList", res);
            model.addAttribute("htmlId", session.getAttribute(userName+"DifId"));
        return "impossibleContent";
    }

    @RequestMapping("removeibTrunkSol")
    @ResponseBody
    public String removeFile(HttpServletRequest request) {
        String res = null;
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        try {
            List<String> fileList = impossibleIbDirService.getFileName(solFilePath + userName + "/");
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            impossibleIbDirService.removeSolFile(userName);
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
