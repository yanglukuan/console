package com.company.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yanglk on 2017/10/30.
 */
public class ThreadPoolCase {

    private static Executor executor= Executors.newFixedThreadPool(2);

    public static void main(String[] args){
        for (int i=0;i<20;i++){
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
