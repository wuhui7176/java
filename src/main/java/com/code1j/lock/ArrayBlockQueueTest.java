package com.code1j.lock;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ wuhui
 * @ date  2017/9/25上午11:21
 */
public class ArrayBlockQueueTest {


    public ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {



        ArrayBlockQueueTest arrayBlockQueueTest = new ArrayBlockQueueTest();


        arrayBlockQueueTest.put();

        arrayBlockQueueTest.get();

    }

    public void get(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        arrayBlockingQueue.take();
                    } catch (InterruptedException e) {

                    }
                    System.out.println("拿去"+arrayBlockingQueue.size());
                }
            }
        });
        thread.start();
    }




    public void put(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        arrayBlockingQueue.put(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("添加"+arrayBlockingQueue.size());
                }
            }
        });
        thread.start();
    }

}
