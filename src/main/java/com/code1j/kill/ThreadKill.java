package com.code1j.kill;



/**
 * @ wuhui
 * @ date  2017/9/21上午9:47
 */
public class ThreadKill {

    public volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {


        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("调用钩子函数");
                run = false;
            }
        }));

        while (run){
            Thread.sleep(10);
        }

    }


    /**
     *
     * kill pid   会调用钩子函数
     *kill -9 pid 不会调用钩子函数
     *
     *
     */

}
