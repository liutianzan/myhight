package com.my.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String [] args) throws InterruptedException, IOException {

        ProcessBuilder pb = new ProcessBuilder("./" + "compile.sh");
        pb.directory(new File("/Users/yueliu/Desktop/myProject/cryptomip/truncdifferentialfrontend/"));
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
}
