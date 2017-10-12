package com.code1j.netty;

import com.alibaba.fastjson.JSONObject;

import java.nio.ByteBuffer; /**
 * @ wuhui
 * @ date  2017/10/12下午1:44
 */
public class RemotingCommand {


    public static Object decode(ByteBuffer byteBuffer) {
        int a = byteBuffer.getInt();
        System.out.println(a);
        byte[] bytes = new byte[a];

        byteBuffer.get(bytes);
        String s = new String(bytes);
        System.out.println("sssssssssss"+s);
        return JSONObject.parse(s);
    }



    private String a ;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
