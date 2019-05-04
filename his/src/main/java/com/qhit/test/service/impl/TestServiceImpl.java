package com.qhit.test.service.impl;

import com.qhit.test.service.ITestService;
import java.util.List;
import com.qhit.test.dao.ITestDao;
import com.qhit.test.pojo.Test;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/24
*/

@Service 
public class TestServiceImpl  implements ITestService {

    @Resource 
    ITestDao dao;

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
        Test test = findById(id); 
        return dao.delete(test); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Test findById(Object id) { 
        List<Test> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Test> search(Test test) { 
        return dao.search(test); 
    }

    @Override
    public void deleteBatch(String[] tIds) {
        dao.deleteBatch(tIds);
    }


}