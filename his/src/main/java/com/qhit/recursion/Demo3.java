package com.qhit.recursion;



/**
 * Created by yy on 2018/12/18.
 */
public class Demo3 {
    /*
       一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第n位数是多少？使用递归实现
*/
   /* public static void main(String[] args) {
        System.out.println(calc(2));
    }
    private  static int calc(int n){
        if (n<=0){
            return 0;
        }
        if (n==1||n==2){
          return 1;
        }
        return calc(n-1)+calc(n+2);
    }*/
private static int i=3;
private static int fum=1;
private static int sum=1;
    public static void main(String[] args) {

    }
    private  static void calc(int n) {
        if (i<=n){
         int tremp=fum;
         fum=sum;

        }
    }

    }
