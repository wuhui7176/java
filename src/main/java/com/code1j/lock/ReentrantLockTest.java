package com.code1j.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ wuhui
 * @ date  2017/8/30下午1:30
 */
public class ReentrantLockTest {


    public ReentrantLock reentrantLock = new ReentrantLock();


    public Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockTest test = new ReentrantLockTest();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                test.reentrantLock.tryLock();


                System.out.println(11111);

                try {
                    Thread.sleep(1000  );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

        Thread.sleep(123);
        test.reentrantLock.tryLock();

        System.out.println(123);


    }


}
