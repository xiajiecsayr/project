package com.qhit.job.pojo;


/** 
* Created by GeneratorCode on 2019/05/05
*/ 

public class Job { 
    private Integer jobId;    //主键 
    private String jobTime;    //发布时间 
    private Integer jobState;    //兼职状态
    private String jobContent; //兼职详情
    private Integer userId;    //发布人 
    private String address;    //地点 
    private String jobName;    //联系人 
    private String jobTel;    //联系方式 
    private Integer exastate;    //审核状态 
    private Integer jobCount;    //剩余招募数 

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) { 
        this.jobId = jobId;
    } 

    public String getJobTime() { 
        return jobTime;
    }

    public void setJobTime(String jobTime) { 
        this.jobTime = jobTime;
    }
    public Integer getJobState() { 
        return jobState;
    }

    public void setJobState(Integer jobState) { 
        this.jobState = jobState;
    } 

    public Integer getUserId() { 
        return userId;
    }

    public void setUserId(Integer userId) { 
        this.userId = userId;
    } 

    public String getAddress() { 
        return address;
    }

    public void setAddress(String address) { 
        this.address = address;
    }
    public String getJobName() { 
        return jobName;
    }

    public void setJobName(String jobName) { 
        this.jobName = jobName;
    }
    public String getJobTel() { 
        return jobTel;
    }

    public void setJobTel(String jobTel) { 
        this.jobTel = jobTel;
    }
    public Integer getExastate() { 
        return exastate;
    }

    public void setExastate(Integer exastate) { 
        this.exastate = exastate;
    } 

    public Integer getJobCount() { 
        return jobCount;
    }

    public void setJobCount(Integer jobCount) { 
        this.jobCount = jobCount;
    } 


 }