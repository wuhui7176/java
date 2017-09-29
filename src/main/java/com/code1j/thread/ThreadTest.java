package com.code1j.thread;

import com.code1j.jvm.JvmTest;

/**
 * @ wuhui
 * @ date  2017/9/29下午2:25
 */
public class ThreadTest {


    public static void main(String[] args) {
//        JvmTest.memSout();

        int i = 0;
        try{
            for (i = 0; i < 10000; i++) {
                System.out.println(i);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            try {
                                Thread.sleep(10000000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        }catch (Exception e){
            System.out.println(i);
        }

    }
}
