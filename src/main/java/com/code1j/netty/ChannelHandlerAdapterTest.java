package com.code1j.netty;

import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;

import java.util.Map;

/**
 * @ wuhui
 * @ date  2017/9/8下午2:41
 */
public class ChannelHandlerAdapterTest extends ChannelInboundHandlerAdapter {

    // register   active   read    ReadComplete(读取完成) channelInactive(闲置) channelUnregistered 卸载

    public ChannelHandlerAdapterTest() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 8);
        //通道建立时   最先执行这里的方法
        super.channelRegistered(ctx);


    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 7);
        //通道关闭时 ，最后执行
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 6);
        // REGISTTER 注册后 激活
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 5);

        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 4);

        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println( "-> " + 3);

        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println( "-> " + 2);

        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println( "-> " + 9);

        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx,msg);
        System.out.println("->"+9999);

        System.out.println(msg);
//        ctx.write(msg); // (1)
//        ctx.flush(); // (2)
////        ctx.channel().close().sync();
        // 第三部
//        System.out.println( "-> " + 1);
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg); // (2)
//        }
    }
}
