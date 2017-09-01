package com.code1j.algorithm;

/**
 * @ wuhui
 * @ date  2017/8/31下午6:20
 */
public class Test2 {

    public static void test(int a){
        if(a>0){
            a = a -1;
            test(a);
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        test(5);
    }

}
