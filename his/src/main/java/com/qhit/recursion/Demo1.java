package com.qhit.recursion;

/**
 * Created by yy on 2018/12/18.
 */
public class Demo1 {
    /* 使用递归求1~n的和*/
    private static int sum=0;
    public static void main(String[] args) {
        calc(10);
        System.out.println(sum);
    }
    private  static void calc(int n){
        if(n>0){
            sum+=n;
            n--;
            calc(n);
        }

    }
}
