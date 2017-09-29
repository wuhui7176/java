package com.code1j.test;

/**
 * @ wuhui
 * @ date  2017/9/29下午4:19
 */
public class DoWhileTest {


    /**
     *
     *
     * do while 语法
     *
     * do 必须 执行一次
     *
     * 执行while判断
     *
     * true 继续执行do 里的语句
     *
     * false 退出
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        int i=100;
        do {

            System.out.println(i);
            i--;
        }while (i!=99);

    }

}
