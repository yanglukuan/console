package com.company.ThreadTest.ThreadPool;

import java.util.concurrent.*;

/**
 * Created by yanglk on 2017/10/30.
 */
public class ThreadPoolCase {

    public static final int ARRAY_QUEUE = 0; //ArrayBlockingQueue  有界队列策略
    public static final int LINKED_QUEUE = 1; //LinkedBlockingQueue 使用无界队列策略

    private ThreadPoolExecutor executor;
    private BlockingQueue<Runnable> workQueue;


    /**
     * @param workQueneSize
     *            队列长度
     * @param coreSize
     *            主线程数
     * @param maxSize
     *            最大线程数
     * @param queueType
     *            队列类型
     */
    public ThreadPoolCase(final int workQueneSize, final int coreSize,
                      final int maxSize, int queueType)
    {
        this(workQueneSize, coreSize, maxSize, queueType, null);
    }

    /**
     *
     * @param workQueneSize
     *            队列长度
     * @param coreSize
     *            主线程数
     * @param maxSize
     *            最大线程数
     * @param queueType
     *            队列类型
     * @param policy
     *            处理策略
     */
    public ThreadPoolCase(final int workQueneSize, final int coreSize,
                      final int maxSize, int queueType, RejectedExecutionHandler policy)
    {
        workQueue = createQueue(queueType, workQueneSize);
        executor = new ThreadPoolExecutor(coreSize, maxSize, 60,
                TimeUnit.SECONDS, workQueue, policy != null ? policy
                : new ThreadPoolExecutor.AbortPolicy());
    }

    public void execute(Runnable runnable)
    {
//        if (workQueue.size() > 4)
//        {

            System.out.println("当前等待线程大小：'"+runnable.getClass().getSimpleName()+
                    "':"+workQueue.size());
        //}
        executor.execute(runnable);
    }


    /**
     * 创建队列，选择不同和队列策略
     * ArrayBlockingQueue  有界队列策略
     * LinkedBlockingQueue 使用无界队列策略
     * @param queueType
     * @param queueSize
     * @return
     */
    private BlockingQueue<Runnable> createQueue(int queueType, int queueSize)
    {
        return queueType == LINKED_QUEUE ? new LinkedBlockingQueue<Runnable>(
                queueSize) : new ArrayBlockingQueue<Runnable>(queueSize);
    }

    public BlockingQueue<Runnable> getQueue()
    {
        return executor.getQueue();
    }




    public static void main(String[] args){

         ThreadPoolCase tp;

        int workQueneSize = 80;
        int coreSize = 2;
        int maxSize = 10;
        //创建线程池
            tp = new ThreadPoolCase(workQueneSize, coreSize, maxSize,
                    ThreadPoolCase.ARRAY_QUEUE);

        for (int i = 0; i < 10; i++)
        {

            tp.execute(new Task("num:" + i));
        }


    }

    static class Task implements Runnable{
        String name;
        public Task(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
            System.out.println("start .." + name);
            try
            {
                // 便于观察，等待一段时间
                Thread.sleep(2000);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            Thread.yield();

        }
    }
}
