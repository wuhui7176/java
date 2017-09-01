package com.code1j.algorithm;

/**
 * @ wuhui
 * @ date  2017/8/31下午3:14
 */
public class MeargeSort {

    public static void main(String[] args) {


        int[] a = new int[]{1,33,3333,0,3,999};

        meargeSort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }


    public static void meargeSort(int[] arr){
        int[] temp =  new int[arr.length];
        internalMeargeSort(arr,temp,0,arr.length-1);

    }

    private static void internalMeargeSort(int[] a,int[] b,int left ,int right){


        if(left <right){


            int middle = (left + right)/2 ;

            internalMeargeSort(a,b,left,middle);

            internalMeargeSort(a,b,middle+1,right);

            meargeSortArray(a,b,left,middle,right);
        }

    }






    private static void meargeSortArray(int arr[],int temp[],int left,int middle,int right){



        int i = left;

        int j = middle+1;
        int k = 0;


        while (i<middle &&j<=right){


            if(arr[i] <= arr[j]){
                temp[k++] =arr[i++];
            }else {
                temp[k++] = arr[j++];
            }

        }

        while (i<=middle){
            temp[k++] =arr [i++];

        }

        while (j<=right){
            temp[k++] = arr[j++];
        }


        for (i = 0;i<k; ++i){
            arr[left+i] = temp[i];
        }
    }
}
