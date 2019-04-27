package com.cryptomip.Differential.trunkDif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DifferentTrunkDirServiceImp implements DifferentTrunkDirService {

    @Value("${sol.trunkdif.file.path}")
    private String solFilePath;
    @Value("${remove.trunkdif.sol.file}")
    private String removeFile;

    //得到文件夹中sol文件名称，并且相应对生成html
    @Override
    public String getDir(String projectName, String userName) {
        List<String> filenameList = getFileName(solFilePath + userName + "/");

        String res = "<table id =\"fileDirectory\" >";
        int count = 0;
        for (String filename : filenameList) {
            if (count % 7 == 0) {
                res += "<tr style=\"height: 150px\">";
            }
            res += "<td style=\"height: 110px;width: 130px\" align=\"center\" valign =\"middle\"><div id=\"pic\"><a href=\"" + projectName + "/getFile/" + filename + "\"><img src=\"myPicture/fileImj.jpg\" id=\"filePic\"/></a>\n<div id=\"picLian\"><span>" + filename + "</span></div></div></td>";
            if (count % 7 == 6) {
                res += "</tr>";
            }
            count++;
        }
        if (count % 7 != 0) {
            res += "</tr>";
        }
        res += "</table>";
        return res;
    }

    //得到文件名称
    @Override
    public List<String> getFileChoose(String projectName, String userName) {
        List<String> filenameList = getFileName(solFilePath+ userName + "/");
        return filenameList;

//        String res = "<table id =\"fileChoose\" >";
//        int count = 0;
//        for (String filename : filenameList) {
//            res += "<tr style=\"height: 150px\">";
//
//            res += "<td style=\"height: 110px;width: 130px\" align=\"center\" valign =\"middle\"><div id=\"pic\"><a href=\"" + projectName + "/getFile/" + filename + "\"><img src=\"${pageContext.request.contextPath}/myPicture/fileImj.jpg\" id=\"filePic\"/></a>\n<div id=\"picLian\"><span>" + filename + "</span></div></div></td>";
//            res += "</tr>";
//
//
//        }
//
//
//        res += "</table>";
//        return res;
    }

    //得到sol文件内容
    @Override
    public String getContent(String fileName, String userName) throws Exception {
        String filePath = solFilePath + userName + "/" + fileName;
        String result = "";
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
        String s = null;
        while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
            result += System.lineSeparator() + s;

        }
        br.close();
        return result;
    }

    @Override
    public List<String> getFileName(String path) {
        Pattern pat = Pattern.compile("\\S+\\.sol");
        File file = new File(path);
        List<String> result = new ArrayList<String>();
        String[] fileName = file.list();

        for (String s : fileName) {
            Matcher mat = pat.matcher(s);
            if (mat.matches())
                result.add(s);
        }
        return result;
    }

    //调用删除文件脚本，将相应对sol文件进行删除
    @Override
    public void removeSolFile(String userName) throws InterruptedException, IOException {
        String pathName = removeFile;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName+ " " + userName;
        Runtime.getRuntime().exec(command2).waitFor();

    }
}