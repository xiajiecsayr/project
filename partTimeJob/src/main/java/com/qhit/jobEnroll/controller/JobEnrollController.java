package com.qhit.jobEnroll.controller; 

import com.qhit.jobEnroll.pojo.JobEnroll; 
import com.qhit.jobEnroll.service.IJobEnrollService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/05/08
*/ 

@RestController 
@RequestMapping("/jobEnroll") 
public class JobEnrollController { 

    @Resource 
    IJobEnrollService jobEnrollService; 

    @RequestMapping("/insert") 
    public void insert(JobEnroll jobEnroll) { 
        jobEnrollService.insert(jobEnroll); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer jeId) { 
        jobEnrollService.delete(jeId); 
    } 

    @RequestMapping("/update") 
    public void update(JobEnroll jobEnroll) { 
        jobEnrollService.update(jobEnroll); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(JobEnroll jobEnroll) { 
        jobEnrollService.updateSelective(jobEnroll); 
    } 

    @RequestMapping("/load") 
    public JobEnroll load(Integer jeId) { 
        JobEnroll jobEnroll = jobEnrollService.findById(jeId); 
        return jobEnroll; 
    } 

    @RequestMapping("/list") 
    public List<JobEnroll> list()  { 
        List<JobEnroll> list = jobEnrollService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<JobEnroll> search(JobEnroll jobEnroll) { 
        List<JobEnroll> list = jobEnrollService.search(jobEnroll); 
        return list; 
    } 

} 
