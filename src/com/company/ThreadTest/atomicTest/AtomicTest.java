package com.company.ThreadTest.atomicTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglk on 2017/11/8.
 */
public class AtomicTest {
    static volatile AtomicInteger al =new AtomicInteger(0);
    static int val;
    static AtomicTest.Add add=new AtomicTest.Add();
    public static class Add implements Runnable{


        @Override
        public void run()
        {
            ThreadLocal th=new ThreadLocal();//测试ThreadLocal
            th.set(al);
            for (int i=0;i<1000;i++) {
                al.getAndIncrement();//正常并发
                val++;//异常并发
            }
            System.out.println(th.get()+Thread.currentThread().getName());//输出每个线程的ThreadLocal保存的值
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(add);
        Thread t2=new Thread(add);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("al:"+al +"val:"+val);
        System.out.print(Runtime.getRuntime().availableProcessors());//输出cpu核心数
    }

}
