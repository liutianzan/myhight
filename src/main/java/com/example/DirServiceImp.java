package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirServiceImp implements DirService {

    @Value("${different.path}")
    private String differentPath;

    @Override
    public String getDir() {
        List<String> filenameList =  getFiles(differentPath);
        String res = "<ul>";

        for(String filename:filenameList){
            res = "<li>"+filename+"</li>";
        }
        res+="</ul>";
        return res;
    }

    public List<String> getFiles(String path) {

        List<String> filenameList = new ArrayList<>();
        File file = new File(path);

        // 如果这个路径是文件夹

        if (file.isDirectory()) {


            // 获取路径下的所有文件

            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                filenameList.add(file.getName());
            }
        }

        // 如果还是文件夹 递归获取里面的文件 文件夹

//                if (files[i].isDirectory()) {
//
//                    System.out.println("目录：" + files[i].getPath());
//
////                    getFiles(files[i].getPath());
//
////                } else {
////
////                    System.out.println("文件：" + files[i].getPath());
////
////                }
//                }
//            }
//
//        } else {
//
//            System.out.println("文件：" + file.getPath());
//
//        }
        return filenameList;

    }


}