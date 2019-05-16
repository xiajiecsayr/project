package com.qhit.jobEnroll.service.impl;

import com.qhit.jobEnroll.service.IJobEnrollService;
import java.util.List;
import com.qhit.jobEnroll.dao.IJobEnrollDao;
import com.qhit.jobEnroll.pojo.JobEnroll;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/05/08
*/

@Service 
public class JobEnrollServiceImpl  implements IJobEnrollService {

    @Resource 
    IJobEnrollDao dao;

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
        JobEnroll jobEnroll = findById(id); 
        return dao.delete(jobEnroll); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public JobEnroll findById(Object id) { 
        List<JobEnroll> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<JobEnroll> search(JobEnroll jobEnroll) { 
        return dao.search(jobEnroll); 
    } 

}