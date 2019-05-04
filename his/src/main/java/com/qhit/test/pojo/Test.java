package com.qhit.test.pojo;


import com.qhit.test1.pojo.Test1;

/**
* Created by GeneratorCode on 2018/12/24
*/

public class Test {

    private Integer tId;    //用户ID
    private String tName;    //用户名
    private String tSex;    //性别
    private Integer tAge;    //年龄

    private String decipher;//解释

    private Test1 test1;

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public String getDecipher() {
        return decipher;
    }

    public void setDecipher(String decipher) {
        this.decipher = decipher;
    }

    public Integer getTId() {
        return tId;
    }
 
    public void setTId(Integer tId) { 
        this.tId = tId;
    }
 
    public String getTName() { 
        return tName;
    }
 
    public void setTName(String tName) { 
        this.tName = tName;
    }
 
    public String getTSex() { 
        return tSex;
    }
 
    public void setTSex(String tSex) { 
        this.tSex = tSex;
    }
 
    public Integer getTAge() { 
        return tAge;
    }
 
    public void setTAge(Integer tAge) { 
        this.tAge = tAge;
    }
 

 }