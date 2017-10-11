package com.code1j.thread;

import java.util.concurrent.Semaphore;

/**
 * @ wuhui
 * @ date  2017/10/10下午3:58
 */
public class SemaphoreTest {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);


        semaphore.tryAcquire();


    }
}
