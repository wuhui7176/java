package com.code1j.thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ wuhui
 * @ date  2017/9/11上午11:56
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {



                    }
                }
            }
        });
        //设置未daemon线程后，主线程关闭后，daemon线程停止运行
        thread.setDaemon(true);
        thread.start();
    }
}
