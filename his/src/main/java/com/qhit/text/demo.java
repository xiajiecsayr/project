package com.qhit.text;

import java.io.File;

/**
 * Created by yy on 2018/12/9.
 */
public class demo {
    public static void main(String[] args) {
        File file=new File("F:\\jsp考试");
        if(file.exists()){
            //获取当前文件夹的名称
            String name = file.getName();
            //返回当前文件夹下所有文件
            File[] files = file.listFiles();
            //判断当前对象是否是文件
            boolean directory = file.isDirectory();
            //该文件所占字符节长度
            long length = file.length();
            System.out.println("文件夹的名称:"+name);
            System.out.println("当前文件夹下所有文件:"+files);
            System.out.println("当前对象是否是文件:"+directory);
            System.out.println("文件所占字符节长度:"+length);



            }else{
            System.out.println("文件不存在");
        }
    }

}
