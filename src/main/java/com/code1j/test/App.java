package com.code1j.test;

/**
 * @ wuhui
 * @ date  2017/9/8上午10:04
 */
public class App {

    public static void main(String[] args) {



        StaticCLassTest.Test test = new StaticCLassTest.Test();

        test.setName("12313");

        StaticCLassTest.Test test1 = new StaticCLassTest.Test();

        test1.setName("2222");


        System.out.println(test1.getName());

    }
}
