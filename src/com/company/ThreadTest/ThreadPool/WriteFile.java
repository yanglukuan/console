package com.company.ThreadTest.ThreadPool;

import sun.plugin.javascript.navig.Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanglk on 2017/11/9.
 */
public class WriteFile {


    public static class Add implements Runnable{

        @Override
        public void run()
        {
            Thread.currentThread().setName(Thread.currentThread().getName().split("\\-")[3]);
            List<String> list=  readTxtFileIntoStringArrList("D:/file/"+Thread.currentThread().getName()+".txt");

            System.out.println(Thread.currentThread().getName()+list);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String directory="D:/file";
        File file = new File(directory);
        if(file.exists() &&  file.isDirectory())
        {
            String[] list=file.list();

            int workQueneSize = 80;
            int coreSize = 12;
            int maxSize = 20;
            //创建线程池
            ThreadPoolExecutor   executor = new ThreadPoolExecutor(coreSize, maxSize, 60,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(workQueneSize),
                     new ThreadPoolExecutor.AbortPolicy());

            for (String name:list){

                executor.execute(new WriteFile.Add());
            }
            executor.shutdown();

            try {
                // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
                while (!executor.awaitTermination(10, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //创建线程
//            for (String name:list){
//              Thread t=  new Thread(new WriteFile.Add(),name.split("\\.")[0]);
//              t.start();
//t.join();
//            }


        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }



    /**
     * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
     *
     * @param filePath
     *            文件路径[到达文件:如： D:\aa.txt]
     * @return 将这个文件按照每一行切割成数组存放到list中。
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

}
