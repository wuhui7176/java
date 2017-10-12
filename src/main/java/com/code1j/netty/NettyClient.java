package com.code1j.netty;

import com.alibaba.fastjson.JSONObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ wuhui
 * @ date  2017/10/12下午2:04
 */
public class NettyClient {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        try {
            Bootstrap bootstrap = new Bootstrap();


            bootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .option(ChannelOption.SO_KEEPALIVE, true) // (4)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch){
                            ch.pipeline().addLast(new NettyEncoder());
                            ch.pipeline().addLast(new NettyDecoder());
                            ch.pipeline().addLast(new ChannelHandlerAdapterTest());
                            ch.pipeline().addLast(new Test2());
                        }
                    });
            // Bind and start to accept incoming connections.
            ChannelFuture f = bootstrap.connect("127.0.0.1",8080);

            Thread.sleep(1000);

            Channel channel = f.channel();

            RemotingCommand remotingCommand = new RemotingCommand();
            remotingCommand.setA("dsadsa");

            while (true){
                channel.writeAndFlush(remotingCommand);
                if(1==2){
                    break;
                }
            }

            channel.close();

            bossGroup.shutdownGracefully();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
