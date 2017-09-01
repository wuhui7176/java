package com.code1j.algorithm;

/**
 * @ wuhui
 * @ date  2017/8/31下午5:43
 */
public class MeargeTest {




    public static void main(String[] args) {
        int[] arr = new int[]{1,33,3333,0,3,999};
        int[] temp =  new int[arr.length];

        inn(arr,temp,0,arr.length-1);

    }


    public static void inn(int[] a,int[] b,int left,int right){
        if(left < right){

            int middle = (left+right)/2;
            System.out.println("test");
            //拆左面
            inn(a,b,left,middle);
            System.out.println("test2");
            //拆右边
            inn(a,b,middle+1,right);
            System.out.println("test3");

        }
    }



}
