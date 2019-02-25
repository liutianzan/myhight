package com.learn.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class myCountDownLatch implements Runnable{
    public static final CountDownLatch c = new CountDownLatch(10);
    public static final myCountDownLatch c1  = new myCountDownLatch();
    @Override
    public void run() {
        try{

            System.out.println("check");
            c.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(5);
        for(int i = 0;i<10;i++){
            e.submit(c1);
        }
        c.await();
        System.out.println("success");
        e.shutdown();
    }

}
