package com.example;

import com.com.test.util.testUUidUtil;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class TestServiceImpl implements TestService {

    @Value("${python.file.path}")
    public String pythonFilePath;

    @Value("${test.path.name}")
    private String filepath;

    @Value("${run.program.script}")
    private String runScriptPath;

    @Value("${tomporary.file.path}")
    private String temporaryFilePath;

    @Value("${delete.file.script}")
    private String deleteFileScript;

    @Value("${compile.file.path}")
    private String compileFilePath;
    @Value("${comile.result.path}")
    private String compileResult;

    @Value("${compile.script.trunkDiff.name}")
    private String compileName;

    public void test() {
        String text = "<div class=\"ace_line\" style=\"height: 16px; top: 0px;\"><span class=\"ace_storage ace_type\">function</span> <span class=\"ace_entity ace_name ace_function\">foo</span><span class=\"ace_paren ace_lparen\">(</span><span class=\"ace_variable ace_parameter\">items</span><span class=\"ace_paren ace_rparen\">)</span> <span class=\"ace_paren ace_lparen\">{</span></div>\n" +
                "<div class=\"ace_line\" style=\"height: 16px; top: 16px;\">    <span class=\"ace_identifier\">var</span> <span class=\"ace_identifier\">i</span><span class=\"ace_punctuation ace_operator\">;</span></div>\n" +
                "<div class=\"ace_line\" style=\"height: 16px; top: 32px;\">    <span class=\"ace_keyword\">for</span> <span class=\"ace_paren ace_lparen\">(</span><span class=\"ace_identifier\">i</span> <span class=\"ace_keyword ace_operator\">=</span> <span class=\"ace_constant ace_numeric\">0</span><span class=\"ace_punctuation ace_operator\">;</span> <span class=\"ace_identifier\">i</span> <span class=\"ace_keyword ace_operator\">&lt;</span> <span class=\"ace_identifier\">items</span><span class=\"ace_punctuation ace_operator\">.</span><span class=\"ace_support ace_constant\">length</span><span class=\"ace_punctuation ace_operator\">;</span> <span class=\"ace_identifier\">i</span><span class=\"ace_keyword ace_operator\">++</span><span class=\"ace_paren ace_rparen\">)</span> <span class=\"ace_paren ace_lparen\">{</span></div>\n" +
                "<div class=\"ace_line\" style=\"height: 16px; top: 48px;\"><span class=\"ace_indent-guide\">    </span>    <span class=\"ace_support ace_function\">alert</span><span class=\"ace_paren ace_lparen\">(</span><span class=\"ace_string\">\"Ace Rocks \"</span> <span class=\"ace_keyword ace_operator\">+</span> <span class=\"ace_identifier\">items</span><span class=\"ace_paren ace_lparen\">[</span><span class=\"ace_identifier\">i</span><span class=\"ace_paren ace_rparen\">])</span><span class=\"ace_punctuation ace_operator\">;</span></div>\n" +
                "<div class=\"ace_line\" style=\"height: 16px; top: 64px;\">    <span class=\"ace_paren ace_rparen\">}</span></div>\n" +
                "<div class=\"ace_line\" style=\"height: 16px; top: 80px;\"><span class=\"ace_paren ace_rparen\">}</span></div>";
        String pat = ">(“[^”]*”|’[^’]*’|[^’”>])*<";
        Pattern r = Pattern.compile(pat);
        Matcher m = r.matcher(text);
        String res = "";
        while (m.find()) {
            String data = m.group(0);
            if (!"".equals(data))

                res += data.substring(1, data.length() - 1);
        }
        System.out.println(res);
    }

    @Override
    public String saveText(String subText) throws Exception {
        System.out.println(subText + "1");
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
        String pathname = filepath;
        String filename = testUUidUtil.getUUID32();
//        resStr = resStr.replace("&gt;",">");
//        resStr = resStr.replace("&lt;","<");
        File f = new File(temporaryFilePath);
        if (!resStr.equals("")) {
            try {
                if (!f.exists()) {
                    f.createNewFile();
                }
                System.out.println(4);
                System.out.println("start write");
                fw = new FileWriter(f);
                BufferedWriter out = new BufferedWriter(fw);
                out.write(resStr, 0, resStr.length());
                out.close();
                System.out.println("write finish");
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
    public void complieProject() throws Exception {
//        String res = compilePython();
//        return res;
        compilePython();
    }

    @Override
    public String buttonA(String sub) throws IOException, InterruptedException {
        String[] args = sub.split(",");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("/Users/yueliu/Desktop/cal.py");

        PyFunction pyFunction = interpreter.get("add", PyFunction.class);
        int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        return pyobj.toString();
    }

    @Override
    public Object buttonB(String sub) throws IOException, InterruptedException {
        String[] args = sub.split(",");
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("/Users/yueliu/Desktop/cal.py");

        PyFunction pyFunction = interpreter.get("mul", PyFunction.class);
        int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        return pyobj.toString();
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
//        String result = getCompileContent();
//        return result;
    }
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
