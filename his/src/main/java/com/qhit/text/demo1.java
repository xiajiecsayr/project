package com.qhit.text;

import java.util.Scanner;

/**
 * Created by yy on 2018/12/27.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int str = sc.nextInt();
        //百位
        int i = str/100;
        //十位
        int j = str/10%10;
        //个位
        int m = str%10%10;
        //输出
        System.out.println(str+"的百位数是："+i+"\n十位数是："+j+"\n个位是："+m);
    }
}
