package com.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fixPool {
    public static void main(String [] args){
        //可以固定线程长度，核心线程数为3，最多创建3个线程数
        ExecutorService newFixThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0;i<10;i++){
            final int temp = i;
            newFixThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+",i:"+temp);
                }
            });
        }
    }
}
