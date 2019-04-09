package com.threadPool.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class schqueuePool {
    public static void main(String [] args){
        ScheduledExecutorService newCheduleed = Executors.newScheduledThreadPool(3);
        //只会创建3个线程，没有对队列进行限制
        //3秒后执行
        for(int i = 0;i<10;i++){
            final int temp = i;
            newCheduleed.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+",i:"+temp);
                }
            },3, TimeUnit.SECONDS);

        }
    }
}
