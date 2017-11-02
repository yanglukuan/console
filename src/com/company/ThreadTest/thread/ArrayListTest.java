package com.company.ThreadTest.thread;

import java.util.ArrayList;

/**
 * Created by lukuanpc on 2017/10/29.
 */
public class ArrayListTest {
    static ArrayList<Integer> al=new ArrayList<>(10);
    static Add in=new Add();
    public static class Add implements Runnable{

        @Override
        public void run()
        {
            for (int i=0;i<1000;i++)
            {
                synchronized (this){
                al.add(i);
            }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(in);
        Thread t2=new Thread(in);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.print(al.size());
    }
}
