package com.cryptomip.ZeroRelated.Trunk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZcTrunkServiceImpl implements ZcTrunkService {
    @Value("${trunkzc.python.path}")
    private String pythonFilePath;

    @Value("${compile.trunkzc.script}")
    private String runScriptPath;

    @Value("${delete.trunkzc.file.script}")
    private String deleteFileScript;

    @Value("${tomporary.file}")
    private String temporaryFilePath;

    @Value("${temporary.trunkzc.file.path}")
    private String temporaryFileName;

    @Value("${remove.trunkzc.solFile}")
    private String removeFile;

    @Value("${analysis.trunkzc.fenxi.path}")
    private String compileFilePath;

    @Value("${analysis.trunkzc.result.path}")
    private String compileResult;

    @Value("${analysis.script.TrunkZc.name}")
    private String compileName;

    @Override
    public String saveText(String subText,String userName) throws Exception {

        if (subText == null || subText.equals("")) return null;
        FileWriter fw = null;


        String resStr = subText;
        File f = new File(temporaryFilePath+userName+"/"+temporaryFileName);
        if (!resStr.equals("")) {
            try {
                if (!f.getParentFile().exists()){
                    f.getParentFile().mkdir();
                }
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
        String result = savePython(userName);
        deletePython(userName);
        return result;
    }
    @Override
    public String savePython(String userName) throws InterruptedException, IOException {
        String pathName = runScriptPath;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName+" "+userName;
        Runtime.getRuntime().exec(command2).waitFor();
        File file = new File(pythonFilePath +userName+ "/result.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
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

    @Override
    public void deletePython(String userName) throws InterruptedException, IOException {
        String pathName = deleteFileScript;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName+" "+userName;
        Runtime.getRuntime().exec(command2).waitFor();
    }

    @Override
    public void removeSolFile(String userName) throws InterruptedException, IOException {
        String pathName = removeFile;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName+" "+userName;
        Runtime.getRuntime().exec(command2).waitFor();

    }
    @Override
    public String complieProject(String userName) throws Exception {
        String res = compilePython(userName);
        return res;
    }
    @Override
    public String compilePython(String userName) throws InterruptedException, IOException {
        ProcessBuilder pb = new ProcessBuilder("./" + compileName,userName);
        pb.directory(new File(compileFilePath));
        int runningStatus = 0;
        String stt = null;
        try {
            Process p = pb.start();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((stt = stdInput.readLine()) != null) {
                System.out.println(stt);
            }
            while ((stt = stdError.readLine()) != null) {
                System.out.println(stt);
            }
            try {
                runningStatus = p.waitFor();
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        String result = getCompileContent(userName);
        return result;
    }
    @Override
    public String getCompileContent(String userName){
        File file = new File(temporaryFilePath+userName+"/"+temporaryFileName);
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
        return result.toString();
    }
}
