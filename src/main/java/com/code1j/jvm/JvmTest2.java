package com.code1j.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ wuhui
 * @ date  2017/9/28下午1:50
 */
public class JvmTest2 {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i <2000 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        JvmTest2 jvmTest2 = new JvmTest2();
                    }
                }
            });
        }


        executorService.shutdown();
    }
}
