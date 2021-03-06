package com.cryptomip.impossibleDifferent.bit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ImpossibleIbDirBitBitServiceImple implements ImpossibleIbDirBitService {
    @Value("${BitId.sol.file.path}")
    private String solFilePath;

    @Value("${remove.BitId.solFile}")
    private String removeFile;

    @Override
    public String getDir(String projectName) {
        List<String> filenameList =  getFileName(solFilePath);

        String res = "<table id =\"fileDirectory\" >";
        int count = 0;
        for(String filename:filenameList){
            if(count%5==0){
                res+="<tr style=\"height: 150px\">";
            }
            res+= "<td style=\"height: 110px;width: 130px\" align=\"center\" valign =\"middle\"><div id=\"pic\"><a href=\""+projectName+"/getibBitFile/"+filename+"\"><img src=\"myPicture/fileImj.jpg\" id=\"filePic\"/></a>\n<div id=\"picLian\"><span>"+filename+"</span></div></div></td>";
            if(count%5==4){
                res+="</tr>";
            }
            count++;
        }
        if(count%5!=0){
            res+="</tr>";
        }
        res+="</table>";
        return res;
    }
    @Override
    public List<String> getFileName(String path)
    {
        Pattern pat=Pattern.compile("\\S+\\.lp");
        File file = new File(path);
        List<String> result = new ArrayList<String>();
        String [] fileName = file.list();

        for(String s:fileName){
            Matcher mat=pat.matcher(s);
            if(mat.matches())
                result.add(s);
        }
        return result;
    }

    @Override
    public List<String> getFileChoose(String projectName) {
        List<String> filenameList = getFileName(solFilePath);
        return filenameList;
    }

    @Override
    public String getContent(String fileName) throws Exception {
        String filePath = solFilePath+fileName;
        String result = "";
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
        String s = null;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            result+=System.lineSeparator()+s;

        }
        br.close();
        return result;
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
}
