package com.cryptomip.Differential.Bit;

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
public class BitDirControll {
    @Autowired
    private BitDirService bitDirService;

    @Value("${bit.sol,file.path}")
    private String solFilePath;


    @RequestMapping("/bitDiffDir")
    @ResponseBody
    public String getDiffDir(HttpServletRequest request) {
        String projectName = request.getContextPath();
        String res = bitDirService.getDir(projectName);
        return res;
    }

    @RequestMapping("bitDifferentPath")
    public String differentPath(String subTxt, String compileRes,Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if(subTxt!=null&&cookie!=null){

            session.setAttribute(cookie.getName()+"DifBIt", subTxt);
            session.setAttribute(cookie.getName()+"ResDifBIt",compileRes);
        }
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()+"DifBIt"));
        return "BitDifferentDir";
    }

    @RequestMapping("/getBitFile/{fileName}")
    public String getContent(@PathVariable("fileName") String filename, ModelMap model, HttpServletRequest request) throws Exception {

        String content = bitDirService.getContent(filename);
        model.addAttribute("text", content);
        model.addAttribute("fileName", filename);
        HttpSession session = request.getSession();
        Cookie cookie = CookieUtil.getToken(request);
        if (cookie != null)
            model.addAttribute("html", session.getAttribute(cookie.getName()+"DifBIt"));
        return "dirBitContent";
    }

    @RequestMapping("removeBitSol")
    @ResponseBody
    public String removeFile() {
        String res = null;
        try {
            List<String> fileList = bitDirService.getFileName(solFilePath);
            if (fileList.size() == 0) {
                return "无可删除文件";
            }
            bitDirService.removeSolFile();
            return "文件删除成功";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
}
