package com.code1j.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteBuffer;

/**
 *
 *
 * LengthFieldBasedFrameDecoder   带包长度的解码器
 * maxFrameLength 长度为 最大包长度
 *lengthFieldOffset 偏移位置
 *lengthFieldLength 包长度的大小
 *解码
 * @ wuhui
 * @ date  2017/10/12下午1:43
 */
public class NettyDecoder extends LengthFieldBasedFrameDecoder {

    public NettyDecoder() {
        super(65536, 0, 4);
    }

    @Override
    public Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = null;
        try {
            frame = (ByteBuf) super.decode(ctx, in);
            in.nioBuffer();
            if (null == frame) {
                return null;
            }
            int a = frame.readInt();
            System.out.println(a);
            byte[] bytes = new byte[a];

            frame.readBytes(bytes);

            System.out.println(new String(bytes));
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            ctx.close();
        } finally {
            if (null != frame) {
                frame.release();
            }
        }

        return null;
    }

}
