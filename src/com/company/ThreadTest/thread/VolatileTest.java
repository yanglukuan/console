package com.company.ThreadTest.thread;

/**
 * Created by yanglk on 2017/11/2.
 */
public class VolatileTest {

   volatile static   boolean  iss;

    public static void main(String[] args) throws InterruptedException {

        Thread th=new Thread(new vol());
        th.start();
        Thread th1=new Thread(new vol());
        th1.start();

        System.out.print(iss);


    }


    public static   class vol implements Runnable{

        @Override
        public void run() {
                iss = true;
                System.out.print(iss+Thread.currentThread().getName());
        }

    }

}
