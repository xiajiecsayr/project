package com.qhit.test1.dao;

import org.springframework.stereotype.Repository;
import com.qhit.test1.pojo.Test1;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/25
*/

@Repository  
public interface ITest1Dao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Test1> search(Test1 test1);

    List findByAName(Object aName);

    List findByTId(Object tId);

}