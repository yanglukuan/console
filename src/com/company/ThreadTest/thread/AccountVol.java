package com.company.ThreadTest.thread;

/**
 * Created by lukuanpc on 2017/10/29.
 */
public class AccountVol implements Runnable {
    static AccountVol in=new AccountVol();
    static  volatile int i=0;
    public synchronized void ins(){
        i++;
    }
    @Override
    public void run(){
        for (int j=0;j<1000000;j++){

                ins();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(in);
        Thread t2=new Thread(in);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.print(i);
    }
}
