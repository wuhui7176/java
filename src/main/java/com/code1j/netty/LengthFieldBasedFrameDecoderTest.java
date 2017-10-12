package com.code1j.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 *
 * 包长度解码测试
 * @ wuhui
 * @ date  2017/10/12下午2:49
 */
public class LengthFieldBasedFrameDecoderTest {

    public static void main(String[] args) {

        String a = "abcdefg";

        byte[] bytes = a.getBytes();

        System.out.println(bytes.length);

        ByteBuf buf = Unpooled.buffer();


        buf.writeInt(5);

        buf.writeBytes(bytes);


        EmbeddedChannel channel = new EmbeddedChannel(new LengthFieldBasedFrameDecoder(1000, 0, 4));
        channel.writeInbound(buf);


        channel.finish();

        ByteBuf b = channel.readInbound();

        System.out.println(b.readInt());



        byte[] bytes1 = new byte[6];


        b.readBytes(bytes1);


        System.out.println(new String(bytes1));
    }

    @Test
    public void test(){


    }
}
