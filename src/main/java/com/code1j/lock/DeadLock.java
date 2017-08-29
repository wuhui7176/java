package com.code1j.lock;

/**
 * @ wuhui
 * @ date  2017/8/29下午5:49
 */
public class DeadLock {

    /**
     * 线程a 拿到  lock1 的锁后去拿 lock2的 锁
     *
     * 线程b 拿到  lock2 的锁后去拿 lock1的锁
     */

    private  Object lock1 = new Object();

    private Object lock2 = new Object();


    public void m1(){
        synchronized (lock1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m2();
        }
    }

    public void m2(){
        synchronized (lock2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m1();
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();


        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.m1();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.m2();
            }
        }).start();
    }

}
