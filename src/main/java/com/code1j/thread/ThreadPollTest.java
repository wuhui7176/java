package com.code1j.thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ wuhui
 * @ date  2017/8/30下午2:55
 */
public class ThreadPollTest {

    public volatile static  boolean flag = true;

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        //创建一个只有一个线程的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <2000 ; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (flag){

                    }
                    atomicInteger.incrementAndGet();
                }
            });
            System.out.println("提交任务"+i);
        }
        flag =false;
        for (;;) {
            System.out.println(atomicInteger.get());
//            System.out.println(executorService.getActiveCount() +"活动线程数量");//做了多少次任务
//            System.out.println(executorService.getTaskCount() +"任务数量");
//            System.out.println(executorService.getPoolSize() +"线程池大小");
//            System.out.println(executorService.getQueue().size() +"等待队列大小");
            Thread.sleep(100);
        }

        //线程中的工作队列  worker  新添加一个任务的时候判断
        //




        //corePoolSize  核心线程池大小  运行线程大于这个后会放到等待队列里

        //maximumPoolSize  最大线程，大于这个数会拒绝任务

        //keepAliveTime


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,100L, TimeUnit.DAYS,
//                new ArrayBlockingQueue<Runnable>(10));
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        //


    }



    @Test
    public void test444(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        arrayBlockingQueue.offer(123);

        System.out.println();
    }


    @Test
    public void test3() throws InterruptedException {
        //corePoolSize  核心线程池大小  运行线程大于这个后会放到等待队列里

        //maximumPoolSize  最大线程，等待队列满后，会继续新建线程 达到 max 个线程后，开始拒绝新的任务

        //keepAliveTime

        //workQueue


        MyThreadPoolExecutor executorService = new MyThreadPoolExecutor(1,300,100L, TimeUnit.DAYS,
                new ArrayBlockingQueue<Runnable>(1));


        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (flag){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        Thread.sleep(1000);

            System.out.println(executorService.getActiveCount() +"活动线程数量");//做了多少次任务
            System.out.println(executorService.getTaskCount() +"任务数量");
            System.out.println(executorService.getPoolSize() +"线程池大小");
            System.out.println(executorService.getQueue().size() +"等待队列大小");

//        for (;;) {
//                        System.out.println(threadPoolExecutor.getPoolSize() +"线程池大小");
//
//        }
    }



    public void test2(){
        //创建一个只有一个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();


    }


    private boolean test21(){

return false;

    }

    @Test
    public void test() throws InterruptedException {


        //大小固定的无界队列线程池，核心大小和最大线程一样，超过最大线程后，任务丢到队列中等待处理
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 0; i <2000 ; i++) {

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (flag){

                    }
                    System.out.println(Thread.currentThread().getName());

                    atomicInteger.incrementAndGet();
                }
            });
            System.out.println("提交任务"+i);
        }
        flag =false;
//        for (;;) {
//            System.out.println(atomicInteger.get());
//            System.out.println(executorService.getActiveCount() +"活动线程数量");//做了多少次任务
//            System.out.println(executorService.getTaskCount() +"任务数量");
//            System.out.println(executorService.getPoolSize() +"线程池大小");
//            System.out.println(executorService.getQueue().size() +"等待队列大小");
//            Thread.sleep(100);
//        }

    }
}
