package com.qhit.test.service;

import java.util.List;
import com.qhit.test.pojo.Test;
/**
* Created by GeneratorCode on 2018/12/24
*/

public interface ITestService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Test findById(Object id);

    List<Test> search(Test test);

    void deleteBatch(String[] tIds);

}