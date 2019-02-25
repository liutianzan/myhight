package com.learn.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglePool {
    public static void main(String [] args){
        ExecutorService newSingle = Executors.newSingleThreadExecutor();
        for(int i = 0;i<10;i++) {
            final int temp = i;
            newSingle.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+",i:"+temp);
                }
            });
        }
    }
}
