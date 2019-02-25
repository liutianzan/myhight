package com.my.test;

import java.util.*;

public class MyExecise {
    public static void main(String [] args){

        String[] arr={"a","b","c"};


        List<String> list=Arrays.asList(arr);

        Collections.shuffle(list);
        System.out.println("随机:"+Arrays.toString(arr));

    }


}
