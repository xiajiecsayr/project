package com.qhit.study.service.impl;

import com.qhit.study.service.IStudyService;
import java.util.List;
import com.qhit.study.dao.IStudyDao;
import com.qhit.study.pojo.Study;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/26
*/

@Service 
public class StudyServiceImpl  implements IStudyService {

    @Resource 
    IStudyDao dao;

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
        Study study = findById(id); 
        return dao.delete(study); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Study findById(Object id) { 
        List<Study> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Study> search(Study study) { 
        return dao.search(study); 
    } 


}