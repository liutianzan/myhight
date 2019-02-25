package com.my.test;

import java.util.ArrayList;

public class SplitNumber {
    public static void main(String [] agrs){
        int [] nums = {1,2,3,4,5,6,7,8};
        ArrayList<StringBuilder> list = new ArrayList<>();
        ArrayList<String> single = new ArrayList<>();
        fullArrange(nums,list,0);
        for(StringBuilder subStr:list){
            for(int i = 0;i<subStr.length()-1;i+=2){
                if(subStr.charAt(i)>subStr.charAt(i+1)){
                    char temp = subStr.charAt(i);
                    subStr.setCharAt(i,subStr.charAt(i+1));
                    subStr.setCharAt(i+1,temp);
                }
            }
        }
        for(StringBuilder n:list){
            for(int i = 0;i<n.length()-3;i+=2){
                for(int j = 0;j<n.length()-3-i;j+=2)
                if(n.charAt(j)>n.charAt(j+2)){
                    char temp = n.charAt(j);
                    char temp1 = n.charAt(j+1);
                    n.setCharAt(j,n.charAt(j+2));
                    n.setCharAt(j+1,n.charAt(j+3));
                    n.setCharAt(j+2,temp);
                    n.setCharAt(j+3,temp1);
                }
            }
        }
        for(StringBuilder s:list){
            if(!single.contains(s.toString())){
                single.add(s.toString());
            }
        }
        ArrayList<ArrayList<ArrayList<Integer>>> resultSort = new ArrayList<>();
        for(String s:single){
            ArrayList<ArrayList<Integer>> sumList = new ArrayList<>();
            for(int i = 0;i<s.length()-1;i+=2){
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(Integer.parseInt(""+s.charAt(i)));
                subList.add(Integer.parseInt(""+s.charAt(i+1)));
                sumList.add(subList);
            }
            resultSort.add(sumList);
        }

        System.out.println(resultSort.size());
        for(ArrayList<ArrayList<Integer>> subSort:resultSort){
            System.out.println(subSort);
        }
    }
    public static void fullArrange(int [] nums,ArrayList<StringBuilder> res,int start){
        if(start==nums.length){
            StringBuilder s = new StringBuilder();
            for(int i = 0;i<nums.length;i++){
                s.append(nums[i]);
            }
            res.add(s);
        }else{
            for(int i = start;i<nums.length;i++){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                fullArrange(nums,res,start+1);
                temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
            }
        }
    }
}
