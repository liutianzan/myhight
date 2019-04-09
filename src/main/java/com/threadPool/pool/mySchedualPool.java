package com.threadPool.pool;

import java.util.concurrent.*;

public class mySchedualPool {
    public static void main(String [] args){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
    }
}
