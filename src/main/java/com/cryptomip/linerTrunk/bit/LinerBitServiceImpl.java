package com.cryptomip.linerTrunk.bit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class LinerBitServiceImpl implements linerBitService {
    @Value("${linerBit.python.path}")
    private String pythonFilePath;

    @Value("${compile.linerBit.script}")
    private String runScriptPath;

    @Value("${delete.linerBit.file.script}")
    private String deleteFileScript;

    @Value("${temporary.linerBit.file.path}")
    private String temporaryFilePath;

    @Value("${remove.linerBit.solFile}")
    private String removeFile;

    @Value("${analysis.linerBit.fenxi.path}")
    private String compileFilePath;

    @Value("${analysis.linerBit.result.path}")
    private String compileResult;

    @Value("${analysis.script.BitLinear.name}")
    private String compileName;

    @Override
    public String saveText(String subText) throws Exception {

        if (subText == null || subText.equals("")) return null;
        FileWriter fw = null;


        String resStr = subText;
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
    @Override
    public String savePython() throws InterruptedException, IOException {
        String pathName = runScriptPath;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();
        File file = new File(pythonFilePath + "resultLinerBit.txt");
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
    public void deletePython() throws InterruptedException, IOException {
        String pathName = deleteFileScript;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();
    }

    @Override
    public void removeSolFile() throws InterruptedException, IOException {
        String pathName = removeFile;

        Process process = null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();

    }
    @Override
    public void complieProject() throws Exception {
        compilePython();
//        return res;
    }
    @Override
    public void compilePython() throws InterruptedException, IOException {
        ProcessBuilder pb = new ProcessBuilder("./" + compileName);
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
    }
    @Override
    public String getCompileContent(){
        File file = new File(compileResult);
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
