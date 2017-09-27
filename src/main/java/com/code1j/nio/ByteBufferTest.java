package com.code1j.nio;

import java.nio.ByteBuffer;

/**
 *
 *
 * 0 <= 标记 <= 位置 <= 限制 <= 容量
 标记，mark
 位置，position
 限制，limit
 容量，capacity
 * @ wuhui
 * @ date  2017/9/27下午2:07
 */
public class ByteBufferTest {


    public static void main(String[] args) {


        ByteBuffer byteBuffer = ByteBuffer.allocate(100);


        byteBuffer.putLong(10);


        System.out.println(byteBuffer.capacity());

        System.out.println(byteBuffer.position());

        System.out.println(byteBuffer.limit());


        System.out.println("=======");




//        System.out.println(byteBuffer.mark());

//
//        byteBuffer.putChar('a');
//
//
//
//        System.out.println(byteBuffer.capacity());
//
//        System.out.println(byteBuffer.position());
//
//        System.out.println(byteBuffer.limit());
//
//        System.out.println(byteBuffer.mark());


//        byteBuffer.flip();


//        byteBuffer.compact();
//        byteBuffer.mark();
        byteBuffer.reset();

        System.out.println(byteBuffer.capacity());

        System.out.println(byteBuffer.position());

        System.out.println(byteBuffer.limit());
//
//        System.out.println(byteBuffer.mark());



    }

    /**
     *
     * filp 反转缓冲区  capacity 不变  limit = post ,position = 0;
     *
     *
     *
     * limit
     在Buffer上进行的读写操作都不能越过这个下标。当写数据到buffer中时，limit一般和capacity相等，当读数据时，
     limit代表buffer中有效数据的长度。


     position
     读/写操作的当前下标。当使用buffer的相对位置进行读/写操作时，读/写会从这个下标进行，并在操作完成后，

     mark
     一个临时存放的位置下标。调用mark()会将mark设为当前的position的值，以后调用reset()会将position属性设
     置为mark的值。mark的值总是小于等于position的值，如果将position的值设的比mark小，当前的mark值会被抛弃掉
     *
     */

}
