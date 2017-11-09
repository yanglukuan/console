package com.company.ThreadTest.threadLocalTest;



/**
 * Created by yanglk on 2017/11/9.
 */
public class ThreadLocalTest {

static {
    System.out.println("静态块");
}


    static int val;
    public static class Add implements Runnable{

       private ThreadLocal th=new ThreadLocal();//测试ThreadLocal
        @Override
        public void run()
        {
            th.set(val);

            for (int i=0;i<1000;i++) {
                val++;//异常并发
            }
            System.out.println(th.get()+Thread.currentThread().getName());//输出每个线程的ThreadLocal保存的值
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1= new Thread(new ThreadLocalTest.Add());
        Thread t2=new Thread(new ThreadLocalTest.Add());
        t1.start();
        t2.start();

    }

}
