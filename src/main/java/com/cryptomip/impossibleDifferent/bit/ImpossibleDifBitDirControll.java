package com.cryptomip.impossibleDifferent.bit;

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
public class ImpossibleDifBitDirControll {
    @Autowired
    private ImpossibleIbDirBitService impossibleIbDirBitService;

    @Value("${BitId.sol.file.path}")
    private String solFilePath;


    @RequestMapping("/ibBitDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {
        String projectName = request.getContextPath();
        String res = impossibleIbDirBitService.getDir(projectName);
        return res;
    }

    @RequestMapping("ibBitPath")
    public String differentPath(String subTxt, String compileRes, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (subTxt != null && cookie != null){
            session.setAttribute(cookie.getName()+"BitId", subTxt);
            session.setAttribute(cookie.getName() + "ResBitId", compileRes);
        }

        if (cookie != null)
            model.addAttribute("htmlBitId", session.getAttribute(cookie.getName()));
        return "impossibleBitPath";
    }

    @RequestMapping("/getibBitFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {

        String content = impossibleIbDirBitService.getContent(filename);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        List<String> res = impossibleIbDirBitService.getFileChoose("");
        model.addAttribute("fileNameList", res);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("htmlBitId", session.getAttribute(cookie.getName()));
        return "impossibleBitContent";
    }

    @RequestMapping("removeibBitSol")
    @ResponseBody
    public String removeFile() {
        String res = null;
        try {
            List<String> fileList = impossibleIbDirBitService.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            impossibleIbDirBitService.removeSolFile();
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
