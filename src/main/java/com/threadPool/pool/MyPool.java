package com.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyPool {
    public static void main(String [ ]args){
        LinkedBlockingDeque l = new LinkedBlockingDeque();

        ExecutorService executorService = new ThreadPoolExecutor(5,5,0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3)){
            public void beforeExecute(Thread t,Runnable r){
                System.out.println("准备执行："+((MyTask)r).name);
            }
            public void afterExecute(Runnable r, Throwable t){
                System.out.println("执行完毕"+((MyTask)r).name);
            }
            public void terminated(){
                System.out.println("线程池关闭");
            }
        };

        for(int i = 0;i<7;i++){
            MyTask m = new MyTask("线程"+i);
            executorService.execute(m);
        }
        executorService.shutdown();
    }
}
class MyTask implements Runnable{
    public String name;
    public MyTask(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}