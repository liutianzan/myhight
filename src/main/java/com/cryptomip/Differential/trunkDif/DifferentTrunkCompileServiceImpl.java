package com.cryptomip.Differential.trunkDif;

import com.baseTool.util.UUidUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class DifferentTrunkCompileServiceImpl implements DifferentTrunkCompileService {

    @Value("${python.file.path}")
    public String pythonFilePath;

    @Value("${test.path.name}")
    private String filepath;

    @Value("${compile.program.trunkdif.script}")
    private String runScriptPath;

    @Value("${tomporary.trunkdif.file.path}")
    private String temporaryFilePath;

    @Value("${delete.file.trunkdif.script}")
    private String deleteFileScript;



    //存储提交的代码
    @Override
    public String saveText(String subText) throws Exception {
        if (subText == null || subText.equals("")) return null;
        FileWriter fw = null;

//        String pattern = "<div class=\"ace_line\" style=\".*\">(.*)</span></div>";
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//        // 现在创建 matcher
//        String patStr = "";
//        Matcher m = r.matcher(subText);
//        while(m.find()) {
//            String data = m.group(0);
//            if (!"".equals(data)){
//
//                patStr = data;
//                break;
//            }
//        }
//        System.out.println(2);
//        System.out.println(patStr);
//        String patStr1 = patStr.replace("</div><div","</div>\n<div");
//        System.out.println(patStr1);
//
//        String resStr = patStr1.replaceAll("<[^>]*>","");
//
//        System.out.println(3);
//        System.out.println(resStr);
        String resStr = subText;
//        resStr = resStr.replace("&gt;",">");
//        resStr = resStr.replace("&lt;","<");
        File f = new File(temporaryFilePath);
        if (!resStr.equals("")) {
            try {
                if (!f.exists()) {
                    f.createNewFile();
                }
                fw = new FileWriter(f);
                BufferedWriter out = new BufferedWriter(fw);
                out.write(resStr, 0, resStr.length());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Map<String, String> res = new HashMap<>();
        res.put("成功", resStr);
        String result = savePython();
        deletePython();
        return result;
    }


    //调用脚本，对提交对代码进行编译
    @Override
    public String savePython() throws InterruptedException, IOException {
        String pathName = runScriptPath;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();
        File file = new File(pythonFilePath + "result.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result.toString();
    }
    //删除编译结果文件
    @Override
    public void deletePython() throws InterruptedException, IOException {
        String pathName = deleteFileScript;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();
    }


}
