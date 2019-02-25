package com.learn.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test0002 {
    public static void main(String [] args){
        //创建线程1、可缓存 2、定长 3、周期 4、单例
        ExecutorService newCancheThreadPoll = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++){
            final int temp = i;
            newCancheThreadPoll.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+",i:"+temp);
                }
            });
        }
    }
}
