package com.company.ThreadTest.thread;

/**
 * Created by lukuanpc on 2017/10/29.
 */
public class ThreadTest {

    public static  long t=0;
    public static  class Cht implements Runnable{
        private long to;
        public Cht(long to){
            this.to=to;
        }


        @Override
        public void run(){

            while (true){
                ThreadTest.t=to;
                Thread.yield();
            }
        }
    }

    public static  class re implements Runnable{
        @Override
        public void run(){
            while (true){
               long temp=ThreadTest.t;
                    System.out.println(temp++);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();


            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Cht(111l)).start();
        new Thread(new Cht(121l)).start();
        new Thread(new ThreadTest.re()).start();
    }
}
