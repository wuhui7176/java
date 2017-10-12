package com.code1j.netty;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteBuffer;

/**
 * 编码
 * @ wuhui
 * @ date  2017/10/12下午1:45
 */
public class NettyEncoder extends MessageToByteEncoder<RemotingCommand> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RemotingCommand remotingCommand, ByteBuf out) throws Exception {
        String json  = JSONObject.toJSONString(remotingCommand);

        byte[] bytes = json.getBytes();

//        ByteBuffer result = ByteBuffer.allocate(bytes.length);
//
//
//        result.put(bytes);
//
//        out.writeBytes(result);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);



    }
}
