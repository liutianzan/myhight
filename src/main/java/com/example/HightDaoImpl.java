package com.example;

import java.io.*;

public class HightDaoImpl implements HightDao {
    public static String pathName1 = "/Users/yueliu/Desktop/CryptoMIP/";
    public static void main(String[] args) throws IOException,InterruptedException {
        String pathName = "/Users/yueliu/Desktop/CryptoMIP/test.sh";

        Process process =null;

        String command1 = "chmod 777 " + pathName;
        process = Runtime.getRuntime().exec(command1);
        process.waitFor();

        String command2 = "/bin/sh " + pathName;
        Runtime.getRuntime().exec(command2).waitFor();
        File file = new File(pathName1+"result.txt");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(result.toString());

    }
}
