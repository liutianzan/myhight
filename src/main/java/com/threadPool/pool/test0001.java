package com.threadPool.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class test0001 {

    public static void main(String [] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("lisi");

        arrayBlockingQueue.offer("as");
        arrayBlockingQueue.offer("zhangsan",3, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("zhangsan1",3, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.size());
    }
}
