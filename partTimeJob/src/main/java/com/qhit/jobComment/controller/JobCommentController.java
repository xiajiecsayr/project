package com.qhit.jobComment.controller; 

import com.qhit.jobComment.pojo.JobComment; 
import com.qhit.jobComment.service.IJobCommentService; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List; 
import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/05/08
*/ 

@RestController 
@RequestMapping("/jobComment") 
public class JobCommentController { 

    @Resource 
    IJobCommentService jobCommentService; 

    @RequestMapping("/insert") 
    public void insert(JobComment jobComment) { 
        jobCommentService.insert(jobComment); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer jcId) { 
        jobCommentService.delete(jcId); 
    } 

    @RequestMapping("/update") 
    public void update(JobComment jobComment) { 
        jobCommentService.update(jobComment); 
    } 

    @RequestMapping("/updateSelective") 
    public void updateSelective(JobComment jobComment) { 
        jobCommentService.updateSelective(jobComment); 
    } 

    @RequestMapping("/load") 
    public JobComment load(Integer jcId) { 
        JobComment jobComment = jobCommentService.findById(jcId); 
        return jobComment; 
    } 

    @RequestMapping("/list") 
    public List<JobComment> list()  { 
        List<JobComment> list = jobCommentService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<JobComment> search(JobComment jobComment) { 
        List<JobComment> list = jobCommentService.search(jobComment); 
        return list; 
    }
} 
