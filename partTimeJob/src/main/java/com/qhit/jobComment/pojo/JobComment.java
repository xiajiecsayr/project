package com.qhit.jobComment.pojo;


/** 
* Created by GeneratorCode on 2019/05/08
*/ 

public class JobComment { 
    private Integer jcId;    //主键 
    private Integer userId;    //评论人 
    private Integer jobId;    //评论贴 
    private String jcTime;    //评论时间 
    private Integer fabulouscount;    //点赞数量 

    public Integer getJcId() { 
        return jcId;
    }

    public void setJcId(Integer jcId) { 
        this.jcId = jcId;
    } 

    public Integer getUserId() { 
        return userId;
    }

    public void setUserId(Integer userId) { 
        this.userId = userId;
    } 

    public Integer getJobId() { 
        return jobId;
    }

    public void setJobId(Integer jobId) { 
        this.jobId = jobId;
    } 

    public String getJcTime() { 
        return jcTime;
    }

    public void setJcTime(String jcTime) { 
        this.jcTime = jcTime;
    }
    public Integer getFabulouscount() { 
        return fabulouscount;
    }

    public void setFabulouscount(Integer fabulouscount) { 
        this.fabulouscount = fabulouscount;
    } 


 }