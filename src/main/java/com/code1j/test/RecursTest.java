package com.code1j.test;

import org.junit.Test;

/**
 * @ wuhui
 * @ date  2017/9/18上午10:23
 */
public class RecursTest {

    @Test
    public static int test(int a){
        if(a>0){
            test(--a);
        }
        return a;
    }

    public static void main(String[] args) {
        int b = test(10);

        System.out.println(b);


        System.out.println(test());
        System.out.println();
    }
    /**
     *
     * 递归
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


    /**
     *
     * @return 返回2
     */
    @Test
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
