package com.learn.pool;



import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutorPool {
    public static void main(String [] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(3));
        threadPoolExecutor.execute(new TaskThread("任务1"));
        threadPoolExecutor.execute(new TaskThread("任务2"));
        threadPoolExecutor.execute(new TaskThread("任务3"));
        threadPoolExecutor.execute(new TaskThread("任务4"));
        threadPoolExecutor.execute(new TaskThread("任务5"));

    }
}
class TaskThread implements Runnable{
    private String taskName;
    public TaskThread(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+taskName);
    }
}