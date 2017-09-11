package com.code1j.test;

/**
 * @ wuhui
 * @ date  2017/9/8上午10:03
 */
public  class StaticCLassTest {

    public StaticCLassTest(){
        System.out.println("init");
    }

    public  static String name1;

    static class Test{

        public void te(){


        }
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
