package com.my.test;

import java.util.Scanner;

public class Test {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[]  array = input.toCharArray();
        int count = 0;
        for(int i = 0,j=array.length-1;i<j; ++i,--j){
            for(;i<j && array[i] =='D';)  ++i;
            for(;i<j && array[j] =='C';) --j;
            if(i<j) count++;

        }
        count++;
        char[]  array1 = input.toCharArray();
        int count1 = 0;
        for(int i = 0,j=array1.length-1;i<j; ++i,--j){
            for(;i<j && array1[i] =='D';)  ++i;
            for(;i<j && array1[j] =='C';) --j;
            if(i<j) count1++;

        }
        count1++;
        int max = Math.min(count,count1);
        System.out.println(count);
    }
}
