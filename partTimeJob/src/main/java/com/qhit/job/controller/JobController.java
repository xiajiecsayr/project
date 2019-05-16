package com.qhit.job.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.ribbon.proxy.annotation.Http;
import com.qhit.job.pojo.Job;
import com.qhit.job.service.IJobService;
import com.qhit.jobEnroll.pojo.JobEnroll;
import com.qhit.jobEnroll.service.IJobEnrollService;
import com.qhit.utils.HttpUtil;
import com.qhit.utils.RedisManager;

import net.sf.json.JSONObject;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Var;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/** 
* Created by GeneratorCode on 2019/05/05
*/ 

@RestController
@RequestMapping("/job")
public class JobController { 
    @Resource
    HttpUtil httpUtil;
    @Resource
    IJobService jobService;
    @Resource
    IJobEnrollService jobEnrollService;

    @RequestMapping("/insert")
    public void insert(Job job,HttpSession session) {
        Map baseUser = jobService.getUesr(session);
        if (job!=null){

            job.setUserId(Integer.parseInt(baseUser.get("userId")+""));
            if (Integer.parseInt(baseUser.get("statusId")+"")==6||Integer.parseInt(baseUser.get("statusId")+"")==1){
                job.setExastate(2);
            }else{
                job.setExastate(1);
            }
            job.setJobState(1);
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String jobtime = format.format(date);
            job.setJobTime(jobtime);

            jobService.insert(job);
        }

    }
   

    @RequestMapping("/delete")
    public void delete(Integer jobId) { 
        jobService.delete(jobId); 
    } 

    @RequestMapping("/update")
    public void update(Job job) {
        jobService.update(job); 
    } 

    @RequestMapping("/updateSelective")
    public void updateSelective(Job job) {
        jobService.updateSelective(job); 
    } 

    @RequestMapping("/load")
    public Job load(Integer jobId) {
        Job job = jobService.findById(jobId);
        return job; 
    } 

    @RequestMapping("/list")
    public List<Job> list(HttpSession session) {
        Map baseUser = jobService.getUesr(session);
        if (baseUser!=null){
            if (Integer.parseInt(baseUser.get("statusId")+"")==6||Integer.parseInt(baseUser.get("statusId")+"")==1){
                return jobService.findOfManage();
            }
            return jobService.findAll();
        }
        return null;
    } 

    @RequestMapping("/search")
    public List<Job> search(Job job,HttpSession session) {
        Map baseUser = jobService.getUesr(session);

            if (Integer.parseInt(baseUser.get("statusId")+"")==6||Integer.parseInt(baseUser.get("statusId")+"")==1){
                return jobService.searchOfManage(job);
            }

        return jobService.search(job);
    }

    @RequestMapping("/findJob")
    public Job findJob(Job job){
        return jobService.findById(job.getJobId());
    }



    @RequestMapping("/apply")
    public boolean apply(Job job,HttpSession session){
        if (job!=null){
            Job byId = jobService.findById(job.getJobId());
            Integer jobCount = byId.getJobCount();
            if (jobCount>=0){
                Map baseUser = jobService.getUesr(session);

                JobEnroll jobEnroll = new JobEnroll();
                jobEnroll.setJobId(job.getJobId());
                jobEnroll.setUserId(Integer.parseInt(baseUser.get("userId") + ""));
                boolean isInsert = jobEnrollService.insert(jobEnroll);
                byId.setJobCount(jobCount--);
                boolean isUpdate = jobService.update(job);
                return isInsert&&isUpdate?true:false;
            }
            return false;
        }

        return false;
    }

} 
