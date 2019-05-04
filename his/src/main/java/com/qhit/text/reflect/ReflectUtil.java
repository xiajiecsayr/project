package com.qhit.text.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yy on 2018/12/6.
 */
public class ReflectUtil {

    public static void reflect(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取类对象
        Class Clazz = object.getClass();
        Method info = Clazz.getMethod("info");
        info.invoke(object);
    }
}
