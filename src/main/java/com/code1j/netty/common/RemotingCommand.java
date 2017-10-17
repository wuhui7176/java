package com.code1j.netty.common;

import com.alibaba.fastjson.JSONObject;

import java.nio.ByteBuffer;

/**
 * @ wuhui
 * @ date  2017/10/12下午1:44
 */
public class RemotingCommand {


    private int code;


    private byte[] body;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
