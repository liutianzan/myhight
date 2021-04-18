package com.cryptomip.Differential.Bit;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Service
public class BitTraceServiceImpl implements BitTraceService {

    @Override
    public HashMap<String, String> getTrace(List<String> fileNameList, String solFilePath) {
        Collections.sort(fileNameList, (o1, o2) -> {
            if (o1.charAt(4) < o2.charAt(4)) {
                return -1;
            }
            if (o1.charAt(4) > o2.charAt(4)) {
                return 1;
            }
            return 0;
        });
        if (fileNameList.size() == 0) {
            return null;
        }
        File file = new File(solFilePath + fileNameList.get(fileNameList.size() - 1));
        StringBuilder readResult = new StringBuilder();
        StringBuilder pr = new StringBuilder();
        String solver = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                readResult.append(System.lineSeparator() + s);
                if (s.startsWith("#")) {
                    solver = s;
                }
                if (s.startsWith("p_r")) {
                    pr.append(System.lineSeparator() + s);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pr.length() == 0) return null;
        String[] s = pr.toString().substring(1, pr.toString().length()).replace("\n", ",").split(",");

        HashMap<String, String> hm = new HashMap<>();
        List<String> subLen = new ArrayList<>();
        for (String re : s) {
            if (re.startsWith("p_r1_")) {
                subLen.add(re);
            }
        }
        for (String re : s) {
            String[] arge = re.split(" ");
            hm.put(arge[0], arge[1]);
        }
        int lunshu = s.length / subLen.size();
//        int height = 20 * 4 / lunshu;
        int height = 20 ;
//        int width = 15 * 32 / subLen.size();
        int width = 15 ;
        int blank = 0;
        if(subLen.size()==32){
            blank = 32;
        }else if(subLen.size() == 64){
            blank = 14;
        }else{
            blank = 0;
        }
        String htmlTable = "<table border=\"1\" id=\"htmlTraceBit\" frame=\"void\">";

        for (int i = 1; i <= lunshu; i++) {
            htmlTable += "<tr height=\"" + height + "\">";
            for(int k = 0;k<blank;k++){
                htmlTable+= "<td width=\"" + width + "\" style=\"border-style:none;\"> </td>";
            }
            htmlTable += "<td width=\"" + width + "\" style=\"border-style:none;\">r" + i + "</td>";

            for (int j = 0; j < subLen.size(); j++) {
                String subVariable = "p_r" + i + "_" + j;
                String var = hm.get(subVariable);
                if (var == null) continue;
                if (var.equals("1.0")) {
                    htmlTable += "<td bgcolor=\"e91e6f\" width=\"" + width + "\">   </td>";
                } else {
                    htmlTable += "<td width=\"" + width + "\"> </td>";
                }
            }
            htmlTable += "</tr>";
        }
        htmlTable += "</table>";
        HashMap<String, String> result = new HashMap<>();
        result.put("tableHtml", htmlTable);
        result.put("solver", solver.substring(1, solver.length()));
        return result;
    }
}
