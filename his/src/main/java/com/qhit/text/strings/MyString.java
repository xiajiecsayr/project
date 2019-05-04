package com.qhit.text.strings;

/**
 * Created by yy on 2018/12/18.
 */
public class MyString {
    public static  char charAt(String str,int i){
        char[] chars = str.toCharArray();
        return chars[i];
    }
    public static String SubString(String str,int begin,int end){
        char[] chars = str.toCharArray();
        String result="";
        for (int i = begin; i <end ; i++) {
            result+=chars[i];
    }
        return result;
    }


}
