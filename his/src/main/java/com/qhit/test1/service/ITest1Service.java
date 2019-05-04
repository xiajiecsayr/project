package com.qhit.test1.service;

import java.util.List;
import com.qhit.test1.pojo.Test1;
/**
* Created by GeneratorCode on 2018/12/25
*/

public interface ITest1Service {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Test1 findById(Object id);

    List<Test1> search(Test1 test1);

}