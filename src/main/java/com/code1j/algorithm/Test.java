package com.code1j.algorithm;

public class Test {

    public static void main(String[] args) {


        test(3);

    }


    public static void test(int a ){

        if(a >0){
            a = a-1;
            test(a);
        }

        System.out.println(a);
    }

}
