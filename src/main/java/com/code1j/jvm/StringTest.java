package com.code1j.jvm;

import io.netty.util.internal.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ wuhui
 * @ date  2017/9/29上午10:54
 */
public class StringTest {


    public static void main(String[] args) {
        List l  = new ArrayList();
        while (true){
            String a = UUID.randomUUID().toString();
            l.add(a);
        }
    }

}
