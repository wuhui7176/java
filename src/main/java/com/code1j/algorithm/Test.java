package com.code1j.algorithm;

/**
 * @ wuhui
 * @ date  2017/8/31下午5:50
 */
public class Test {
    public static int b = 0;
    public static void main(String[] args) {
        test(null,3);
    }


    public static void test(String a ,int i){
//        i--;

        if(i >0){
            b++;

//            test("a", --i);
            test("b",--i);
        }

        System.out.println(i);
    }


    public static void test2(int a){



    }








}
