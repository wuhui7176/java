package com.code1j.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ wuhui
 * @ date  2017/9/26下午1:57
 */
public class StackTest {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.my();
    }






    public void my(){
        System.out.println(atomicInteger.incrementAndGet());
        my();
    }
}
