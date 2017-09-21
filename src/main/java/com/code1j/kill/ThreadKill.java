package com.code1j.kill;


import java.io.IOException;

/**
 * @ wuhui
 * @ date  2017/9/21上午9:47
 */
public class ThreadKill {

    public volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException, IOException {



        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("调用钩子函数");
                run = true;
                int i = 0;
                while (run) {
                    try {
                        if(i<10){
                            Thread.sleep(80);
                            i++;
                        }else break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(1);
//                }
//            }
//        }).start();
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
