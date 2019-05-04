package com.qhit.test;

public class demo1 {

    public static void main(String[] args) {

        Integer[] arr = {1,5,2,9,3,6,7,2,4};

//        sort1(arr);
        sort3(arr);

    }

    public static void sort1(Integer[] arr){

        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    Integer temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort2(Integer[] arr){

        for (int i = 1; i <= arr.length-1 ; i++) {

            for (int j = i-1; j >=0; j--) {
                if (arr[j]<arr[j+1]) {
                    Integer temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }else {
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void sort3(Integer[] arr){

        for (int i = 0; i <= arr.length-1 ; i++) {

            for (int j = i+1; j <= arr.length-1; j++) {
                if (arr[i]>arr[j]){
                    Integer temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
