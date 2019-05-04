package com.qhit.text.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yy on 2018/12/6.
 */
public class FandianProxy implements InvocationHandler {
    private Object object;
    //获取对象的代理实例
    public Object getInstance(Object obj){
        this.object=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("点餐....");
        Object result = method.invoke(object, args);
        System.out.println("结账....");
        return result;
    }
}
