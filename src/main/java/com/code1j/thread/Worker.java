package com.code1j.thread;

/**
 * @ wuhui
 * @ date  2017/9/22下午5:14
 */
public class Worker  {


    private Thread thread;

    private Runnable runnable;


    public Worker(Runnable runnable){
        thread = new Thread(runnable);
        run(runnable);
    }


    public void run(Runnable runnable){
        Thread thread  =Thread.currentThread();
        runnable.run();
    }


    public static void main(String[] args) {

        Worker worker = new Worker(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
            }
        });

        worker.thread.start();


    }



}
