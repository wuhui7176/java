package com.code1j.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * @ wuhui
 * @ date  2017/10/12下午3:55
 */
public class ByteBufToByteBuffer {


    public static void main(String[] args) {



        ByteBuf byteBuf = Unpooled.buffer();

        byteBuf.writeInt(1);



        ByteBuffer byteBuffer =byteBuf.nioBuffer();


        System.out.println(byteBuffer.getInt());
    }
}
