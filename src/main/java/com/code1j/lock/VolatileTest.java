package com.code1j.lock;

import org.junit.Test;

/**
 * @ wuhui
 * @ date  2017/8/29下午5:58
 */
public class VolatileTest {

    private volatile boolean flag = false;

    @Test
    public void test1(){


        for (int i = 0; i <20 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        flag = !flag ;
                        System.out.println(Thread.currentThread().getId()+"1"+flag);
                    }
                }
            }).start();
        }




    }


}
