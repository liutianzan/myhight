package com.example.demo.com.test.service;

import com.com.test.util.testUUidUtil;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TestServiceImpl implements TestService{
    @Test
    public void test(){
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
        while(m.find()) {
            String data = m.group(0);
            if (!"".equals(data))

                res+=data.substring(1,data.length()-1);
        }
        System.out.println(res);
    }
    @Override
    public Object saveText(String subText) throws Exception{
        if(subText==null||subText.equals(""))return null;
        FileWriter fw = null;
        String pattern = "\\<div class=\\\"ace\\_line\\\" style\\=\\\"height\\: 16px\\; top\\: 0px\\;\\\"\\>(.*)\\<\\/span\\>\\<\\/div\\>";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher
        String patStr = "";
        Matcher m = r.matcher(subText);
        while(m.find()) {
            String data = m.group(0);
            if (!"".equals(data)){

                patStr = data;
                break;
            }
        }
        System.out.println(patStr);
        String patStr1 = patStr.replace("</div><div","</div>\n<div");
        System.out.println(patStr1);
        String pattern1 = ">(“[^”]*”|’[^’]*’|[^’”>])*<";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(patStr1);
        String resStr = "";
        while(m1.find()) {
            String data = m1.group(0);
            if (!"".equals(data)){
                resStr+=data.substring(1,data.length()-1);
            }
        }
        System.out.println(resStr);
        String pathname = "/Users/yueliu/Desktop/test1/picture/";
        String filename = testUUidUtil.getUUID32();
        resStr = resStr.replace("&gt;",">");
        resStr = resStr.replace("&lt;","<");
        File f = new File(pathname+filename+".txt");
        try {
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(resStr, 0, resStr.length());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> res = new HashMap<>();
        res.put("成功",resStr);
        return res;
    }
}
