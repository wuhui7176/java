package com.code1j.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ wuhui
 * @ date  2017/8/30下午2:55
 */
public class ThreadPollTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //corePoolSize  核心线程池大小  运行线程大于这个后会放到等待队列里

        //maximumPoolSize  最大线程，大于这个数会拒绝任务
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,100L, TimeUnit.DAYS,
                new ArrayBlockingQueue<Runnable>(10));

        //



    }


    @Test
    public void test(){

        System.out.println(123456);



    }
}
