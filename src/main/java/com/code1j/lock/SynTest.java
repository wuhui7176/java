package com.code1j.lock;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * @ wuhui
 * @ date  2017/8/29下午5:37
 */
public class SynTest {

    public static void main(String[] args) {
        SynTest synTest= new SynTest();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synTest.inrc();
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synTest.less();
                }
            }
        }).start();

//        System.out.println("key = "+synTest.ck);
    }




    public  Object lock = new Object();

    int ck= 0;

    public void inrc(){
        synchronized (lock){
            ck++;
            System.out.println(Thread.currentThread().getId()+"===" + ck);
            try {
                if(ck%2==0)
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void less(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getId()+"===" + ck);
            ck--;
            lock.notify();
        }
    }
}
