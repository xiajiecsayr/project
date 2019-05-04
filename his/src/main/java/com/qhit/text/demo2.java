package com.qhit.text;

import org.springframework.aop.support.AopUtils;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by yy on 2018/12/29.
 */

//随机生成多个不重复的数，进行排序
public class demo2 {

    public static void main(String[] args) {
        int[] b = rde(10,70);
        System.out.println("生成的随机数为："+ Arrays.toString(b));
        //进行排序
        /*arrange(b);*/
        //选择排序
        choice(b);
        //冒泡排序
        /*bubbling(b);*/
        //要查找的数字
        int key = 12;
        //二分查找
        /*System.out.println(key+"在该数字第"+(dichotomy(b,key)+1)+"位");*/
        //递归查找
        System.out.println(key+"在该数字第"+(recursion(b,key,0,b.length-1)+1)+"位");
        System.out.println("排序后："+Arrays.toString(b));
    }

    public static int[] rde(int n,int m){
        Set<Integer> set = new HashSet<Integer>();
        //随机数
        Random random = new Random();
        while (set.size()<n){
            set.add(random.nextInt(m)+1);
        }
        Object[] objects = set.toArray();
        int[] aa = new int[objects.length];
        for (int i=0;i<objects.length;i++){
            aa[i]=(int)objects[i];
        }
        return aa;
    }

    //插入排序
    public static void arrange(int[] ascending){

        int a = 0; //下标
        int temp=0;//值
        for(int i=1;i<ascending.length;i++){
                a = i;
                temp = ascending[a];

            while (i>0 && ascending[i-1]>temp){
                ascending[i]=ascending[i-1];
                i--;
            }
            ascending[i]=temp;
        }
    }

    //选择排序

    public static void choice(int[] a){
        int min=0;
        for(int i = 0;i<a.length;i++){
            min = i;
            for (int j= min+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
    }

    //冒泡排序
    public static void bubbling(int[] a){
        for (int i=0;i<a.length;i++){
            boolean flag = true;
            for (int j =0;j<a.length-1;j++){
                if(a[j]>a[i]){
                    int temp = a[j];
                    a[j]=a[i];
                    a[i]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    //二分查找||半分查找
    public static int dichotomy(int[] a,int key){
        int low=0;
        int middle=0;
        int high=a.length-1;
        while (low<=high){
            middle=(low+high)/2;
            if(a[middle]==key){
                return middle;
            }else if(key>a[middle]){
                low = middle+1;
            }else {
                high = middle-1;
            }
        }
        return -1;
    }

    //递归查找
    private static int recursion(int[] a,int key,int low,int high){
        if(low<high){
            int middle=(low+high)/2;
            if(a[middle]==key){
                return middle;
            }else if(key>a[middle]){
                return recursion(a,key,middle+1,high);
            }else {
                return recursion(a,key,low,middle-1);
            }
        }
        return -1;
    }

}
