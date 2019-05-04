package com.qhit.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Exception;

/**
 * Created by yy on 2018/12/14.
 */
@Component
@Aspect
public class Exceptioninfo {
    @AfterThrowing(value = "execution(* com.qhit.*.controller.*.*(..))",throwing = "e")
    public void after(Exception e){
        System.out.println("异常原因：");
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw,true));
        String info = sw.toString();
        String[] arr = info.split("\r\n");
        int len = arr.length>4?4:arr.length;
        for (int i =0;i<len;i++){
            System.out.println(arr[i]);
        }
    }
}
