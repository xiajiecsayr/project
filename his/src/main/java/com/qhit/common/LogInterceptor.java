package com.qhit.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by yy on 2018/12/12.
 */
@Component
@Aspect
public class LogInterceptor {

    @Before(value = "execution(* com.qhit.*.controller.*.*(..))")
//    public void before(){
//        System.out.println("方法开始执行");
//    }


    //前置通知
    public void before(JoinPoint jp){
        //类名称
        String ClassName = jp.getTarget().getClass().getName();
        //方法名称
        String FangFaCname = jp.getSignature().getName();
        //参数
        Object[] args = jp.getArgs();
        String CanShuArgs = Arrays.toString(args);
        //时间
        SimpleDateFormat format = new SimpleDateFormat();
        String info = format.format(new Date());
        System.out.println(info+"开始执行"+ClassName+"下的"+FangFaCname+"方法\n参数是："+CanShuArgs);
    }

    //后置通知
    @AfterReturning(returning = "result",value = "execution(* com.qhit.*.controller.*.*(..))")
    public void after(JoinPoint jp,Object result){
        //类名称
        String ClassName = jp.getTarget().getClass().getName();
        //方法名称
        String FangFaCname = jp.getSignature().getName();
        //时间
        SimpleDateFormat format = new SimpleDateFormat();
        String info = format.format(new Date());
        System.out.println(info+"结束执行"+ClassName+"下的"+FangFaCname+"方法\n返回值是："+result);

    }
}
