package com.code1j.test;

import java.util.concurrent.Executor;

/**
 * @ wuhui
 * @ date  2017/9/4下午4:08
 */
public class TryCatchTest {


    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){

        try {

//            int b = 1/0;
            return 4;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
//        System.out.println(22222);
//        return 3;
    }

}
