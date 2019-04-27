package com.cryptomip.Differential.trunkDif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class DifferentTrunkAnalysisServiceImpl implements DifferentTrunkAnalysisService {
    @Value("${analysis.trunkdif.file.path}")
    private String compileFilePath;


    @Value("${analysis.script.trunkDiff.name}")
    private String compileName;

    @Value("${analysis.trunkdif.result.path}")
    private String compileResult;

    @Override
    public void complieProject(String userName) throws Exception {
//        String res = compilePython();
//        return res;
        compilePython(userName);
    }
    //分析代码
    @Override
    public void compilePython(String userName) throws InterruptedException, IOException {

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
//        String result = getCompileContent();
//        return result;
    }

    //查看分析结果文件
    @Override
    public String getAnalysisContent() {
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
