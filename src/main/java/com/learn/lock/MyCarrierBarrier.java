package com.learn.lock;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class MyCarrierBarrier {
    public static class Solder implements Runnable{
        private String soldier;
        private CyclicBarrier cyclicBarrier;
        public Solder(CyclicBarrier cyclicBarrier,String soldierName){
            this.cyclicBarrier = cyclicBarrier;
            this.soldier = soldierName;
        }
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(soldier+"完成任务");
        }
    }
   public static class Barrier implements Runnable{
        boolean flag;
        int N;
        public Barrier(boolean flag,int N){
            this.flag = flag;
            this.N = N;
        }
       @Override
       public void run() {
            if(flag){
                System.out.println("司令：[士兵"+N+"个，任务完成！]");
            }else{
            System.out.println("司令：[士兵"+N+"个，集合完毕！]");
            flag = true;
            }
       }
   }

    public static void main(String [] args){
        final int n = 10;
        Thread[] allSo = new Thread[n];
        boolean flag = false;
        CyclicBarrier ccy = new CyclicBarrier(n,new Barrier(false,n));
        System.out.println("队伍集合");
        for(int i = 0;i<n;i++){
            System.out.println("士兵"+i+" 报道");
            allSo[i] = new Thread(new Solder(ccy,"士兵"+i));
            allSo[i].start();
        }
    }
}
