package com.code1j.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ wuhui
 * @ date  2017/10/10下午2:23
 */
public class ScheduledExecutorServiceTest {


    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


        //2 启动时多久开始执行第一次任务
        //3 每隔多久执行一次任务
        //4
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        },1,1, TimeUnit.SECONDS);



    }
}
