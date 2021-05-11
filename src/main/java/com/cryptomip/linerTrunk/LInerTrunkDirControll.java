package com.cryptomip.linerTrunk;

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
public class LInerTrunkDirControll {
    @Autowired
    private LInerTrunkDirService bitDirService;

    @Value("${liner.sol.trunk.path}")
    private String solFilePath;


    @RequestMapping("/linerTrunkDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String projectName = request.getContextPath();
        String res = bitDirService.getDir(projectName, userName);
        return res;
    }

    @RequestMapping("linerTrunkPath")
    public String differentPath(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        if (subTxt != null) {

            session.setAttribute(userName + "TrunkLinear", subTxt);
            session.setAttribute(userName + "ResTrunkLinear", compileRes);
        }
        model.addAttribute("html", session.getAttribute(userName + "TrunkLinear"));
        return "linerTrunkPath";
    }

    @RequestMapping("/getLinerTrunkFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String content = bitDirService.getContent(filename, userName);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        model.addAttribute("html", session.getAttribute(userName + "TrunkLinear"));
        return "linerTrunkContent";
    }

    @RequestMapping("removeLinerTrunkSol")
    @ResponseBody
    public String removeFile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = CookieUtil.getUserName(session);
        String res = null;
        try {
            List<String> fileList = bitDirService.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            bitDirService.removeSolFile(userName);
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
