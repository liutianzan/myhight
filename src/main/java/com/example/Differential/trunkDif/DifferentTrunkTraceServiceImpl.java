package com.example.Differential.trunkDif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Service
public class DifferentTrunkTraceServiceImpl implements DifferentTrunkTraceService {

    @Value("${sol.file.path}")
    private String solFilePath;

    @Override
    public HashMap<String,String> getTrace(List<String> fileNameList) {
        Collections.sort(fileNameList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(4)<o2.charAt(4)){
                    return -1;
                }
                if(o1.charAt(4)>o2.charAt(4)){
                    return 1;
                }
                return 0;
            }
        });
        if(fileNameList.size()==0){
            return null;
        }
        File file = new File(solFilePath + fileNameList.get(fileNameList.size()-1));
        StringBuilder readResult = new StringBuilder();
        StringBuilder pr = new StringBuilder();
        String solver = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                readResult.append(System.lineSeparator() + s);
                if(s.startsWith("#")){
                    solver = s;
                }
                if(s.startsWith("p_r")){
                    pr.append(System.lineSeparator() + s);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(pr.length()==0)return null;
        String[] s = pr.toString().substring(1,pr.toString().length()).replace("\n",",").split(",");

        HashMap<String,String> hm = new HashMap<>();
        List<String> subLen = new ArrayList<>();
        for(String re:s){
            if(re.startsWith("p_r0_")){
                subLen.add(re);
            }
        }
        for(String re:s){
            String[] arge = re.split(" ");
            hm.put(arge[0],arge[1]);
        }
        int lunshu = s.length/subLen.size();
        int height = 20*4/lunshu;
        int width = 15*32/subLen.size();
        String htmlTable = "<table border=\"1\" id=\"htmlTrace\" frame=\"void\">";
        htmlTable+="<tr height=\""+height+"\">";
        htmlTable+="<td width=\""+width+"\" style=\"border-style:none;\"> </td>";
        for(int i = 0;i<subLen.size();i++){
            htmlTable+="<td width=\""+width+"\" style=\"border-style:none;\">"+i+"</td>";
        }
        htmlTable+="</tr>";
        for(int i = 0;i<lunshu;i++){
            htmlTable+="<tr height=\""+height+"\">";
            htmlTable+="<td width=\""+width+"\" style=\"border-style:none;\">r"+i+"</td>";

            for(int j = 0;j<subLen.size();j++){
                String subVariable = "p_r"+i+"_"+j;
                String var = hm.get(subVariable);
                if(var==null)continue;
                if(var.equals("1.0")){
                    htmlTable+="<td bgcolor=\"e91e6f\" width=\""+width+"\">   </td>";
                }else{
                    htmlTable+="<td width=\""+width+"\"> </td>";
                }
            }
            htmlTable+="</tr>";
        }
        htmlTable+="</table>";
        HashMap<String,String> result = new HashMap<>();
        result.put("tableHtml",htmlTable);
        result.put("solver",solver.substring(1,solver.length()));
        return result;
    }
}
