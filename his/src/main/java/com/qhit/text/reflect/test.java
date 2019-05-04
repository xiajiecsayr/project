package com.qhit.text.reflect;

import com.qhit.text.reflect.Student;
import com.qhit.text.reflect.Teacher;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yy on 2018/12/6.
 */
public class test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        /*Student s = new Student();*/
        Teacher s = new Teacher();
        ReflectUtil.reflect(s);
        /*s.info();*/
    }
}
