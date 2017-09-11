package com.code1j.lock;

public class WaitNotifyTest {


    /**
     * 拿到一个对象的锁后，调用wait 方法后，线程会进入等待，并且释放拿到的锁
     * 另一个线程拿到这个对象锁后调用 notify 后，并且释放锁后，另一个等待的线程会唤起
     *
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (WaitNotifyTest.class){
                    try {
                        System.out.println("123");
                        WaitNotifyTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("abc");
                }
            }
        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (WaitNotifyTest.class){
//                    //另一个等待在这个锁上的线程会立即执行
//                    WaitNotifyTest.class.notify();
//                    System.out.println("def");
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("456");
//                }
//
//            }
//        });

        thread.start();
        Thread.sleep(10);
//        thread2.start();
        synchronized (  WaitNotifyTest.class){
            WaitNotifyTest.class.notify();
        }


    }

}
