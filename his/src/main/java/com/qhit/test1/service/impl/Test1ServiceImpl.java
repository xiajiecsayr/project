package com.qhit.test1.service.impl;

import com.qhit.test1.service.ITest1Service;
import java.util.List;
import com.qhit.test1.dao.ITest1Dao;
import com.qhit.test1.pojo.Test1;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/25
*/

@Service 
public class Test1ServiceImpl  implements ITest1Service {

    @Resource 
    ITest1Dao dao;

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
        Test1 test1 = findById(id); 
        return dao.delete(test1); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Test1 findById(Object id) { 
        List<Test1> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Test1> search(Test1 test1) { 
        return dao.search(test1); 
    } 


}