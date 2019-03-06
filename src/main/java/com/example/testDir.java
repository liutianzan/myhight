package com.example;

import java.io.*;
import java.util.*;

public class testDir {
    public static void main(String [] agrs) {


        File file = new File("/Users/yueliu/Desktop/myProject/cryptomip/temp3.sol");
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
        int height = 100/lunshu;
        int width = 100/subLen.size();
        int startWid = width+2;
        String htmlTable = "<table border=\"1\" id=\"htmlTrace\" frame=\"void\" style=\"table-layout:fixed; width:100%; height:90%;>";
        htmlTable+="<tr style=\"height:"+height+"\">";
        htmlTable+="<td style=\"border-style:none; width: "+startWid+"%;\"> </td>";
        for(int i = 0;i<subLen.size();i++){
            htmlTable+="<td  style=\"border-style:none;width: "+width+"%;\">"+i+"</td>";
        }
        htmlTable+="</tr>";
        for(int i = 0;i<lunshu;i++){
            htmlTable+="<tr style=\"height:"+height+"\">";
            htmlTable+="<td style=\"border-style:none;width:"+startWid+"%;\">r"+i+"</td>";

            for(int j = 0;j<subLen.size();j++){
                String subVariable = "p_r"+i+"_"+j;
                String var = hm.get(subVariable);
                if(var==null)continue;
                if(var.equals("1.0")){
                    htmlTable+="<td bgcolor=\"e91e6f\" style=\"width:"+width+"%;\">   </td>";
                }else{
                    htmlTable+="<td style=\"width:"+width+"%;\"> </td>";
                }
            }
            htmlTable+="</tr>";
        }
        htmlTable+="</table>";
    }
        public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    public static void getFiles(String path) {
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    System.out.println("目录：" + files[i].getPath());
                    getFiles(files[i].getPath());
                } else {
                    System.out.println("文件：" + files[i].getPath());
                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
        }
    }
}
