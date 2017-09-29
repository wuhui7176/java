package com.code1j.jvm;


import java.nio.ByteBuffer;

/**
 * @ wuhui
 * @ date  2017/9/29上午9:24
 */
public class JvmTest3 {


    public static void main(String[] args) {



        long max = Runtime.getRuntime().maxMemory();
        long freeMem =Runtime.getRuntime().freeMemory();
        System.out.println("最大堆内存"+max/1024/1024);
        System.out.println("剩余空间"+freeMem/1024/1024);

        //申请直接内存，不需要消耗堆内存空间
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 );

        //申请堆内存空间，需要消耗堆内存空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024 );
//        Byte[] bytes = new Byte[1024*1024 *1024];

        //
        long max1 = Runtime.getRuntime().maxMemory();
        long freeMem1 =Runtime.getRuntime().freeMemory();
        System.out.println("最大堆内存"+max1/1024/1024);
        System.out.println("剩余空间"+freeMem1/1024/1024);
    }

}
