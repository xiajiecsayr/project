package com.qhit.test.dao;

import org.springframework.stereotype.Repository;
import com.qhit.test.pojo.Test;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/24
*/

@Repository  
public interface ITestDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Test> search(Test test);

    List findByTName(Object tName);

    List findByTSex(Object tSex);

    List findByTAge(Object tAge);

    void deleteBatch(String[] tIds);
}