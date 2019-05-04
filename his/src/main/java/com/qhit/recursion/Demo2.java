package com.qhit.recursion;

/**
 * Created by yy on 2018/12/18.
 */
public class Demo2 {
    /*判断一个int类型的数是否是回文(对称的数)*/

    private static boolean flag=true;

    public static void main(String[] args) {
        hws(34543);
        System.out.println(flag);

    }
    private static void  hws(int i){
        String num=""+1;
        if(num.length()>=2){
            if (num.charAt(0)==num.charAt(num.length())-1){
               num = num.substring(1, num.length() - 1);
                hws(Integer.parseInt(num));
            }else {
                 flag=true;
                 return;
            }
        }
    }
}
