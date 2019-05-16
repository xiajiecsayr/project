package com.qhit.jobComment.service.impl;

import com.qhit.jobComment.service.IJobCommentService;
import java.util.List;
import com.qhit.jobComment.dao.IJobCommentDao;
import com.qhit.jobComment.pojo.JobComment;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/05/08
*/

@Service 
public class JobCommentServiceImpl  implements IJobCommentService {

    @Resource 
    IJobCommentDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 

    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 

    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 

    @Override 
    public boolean delete(Object id) { 
        JobComment jobComment = findById(id); 
        return dao.delete(jobComment); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public JobComment findById(Object id) { 
        List<JobComment> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<JobComment> search(JobComment jobComment) { 
        return dao.search(jobComment); 
    } 

}