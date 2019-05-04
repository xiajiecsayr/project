package com.qhit.interfaces;

/**
 * Created by yy on 2018/12/17.
 */
public class EngineerFactory {
    public static Engineer getEngineer(){
           return new EngineerMiddle();
    }



}
