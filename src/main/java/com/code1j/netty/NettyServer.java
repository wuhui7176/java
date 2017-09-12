package com.code1j.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ wuhui
 * @ date  2017/9/8下午2:12
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch){
                            ch.pipeline().addLast(new ChannelHandlerAdapterTest());
                            ch.pipeline().addLast(new Test2());
                        }
                    });
            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(8080).sync();

            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }catch (Exception e){

        }
    }

}
