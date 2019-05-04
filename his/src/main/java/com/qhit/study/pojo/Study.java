package com.qhit.study.pojo;


import com.qhit.site.pojo.Site;

/**
* Created by GeneratorCode on 2018/12/26
*/

public class Study {

    private Integer sId;    //学生id
    private String sName;    //学生姓名
    private String sSex;    //性别
    private Integer sAge;    //年龄
    private Integer sSiteid;    //地址id

    private Site site;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Integer getSId() {
        return sId;
    }
 
    public void setSId(Integer sId) { 
        this.sId = sId;
    }
 
    public String getSName() { 
        return sName;
    }
 
    public void setSName(String sName) { 
        this.sName = sName;
    }
 
    public String getSSex() { 
        return sSex;
    }
 
    public void setSSex(String sSex) { 
        this.sSex = sSex;
    }
 
    public Integer getSAge() { 
        return sAge;
    }
 
    public void setSAge(Integer sAge) { 
        this.sAge = sAge;
    }
 
    public Integer getSSiteid() { 
        return sSiteid;
    }
 
    public void setSSiteid(Integer sSiteid) { 
        this.sSiteid = sSiteid;
    }
 

 }