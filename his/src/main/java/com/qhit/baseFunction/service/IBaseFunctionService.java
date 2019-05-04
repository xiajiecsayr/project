package com.qhit.baseFunction.service;

import java.util.List;
import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseModule.pojo.BaseModule;

/**
* Created by GeneratorCode on 2018/11/28
*/

public interface IBaseFunctionService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseFunction findById(Object id);

    List<com.qhit.baseFunction.controller.BaseFunctions> findAlls();

    /*List<BaseFunction> findByMid(Integer mid);*/

    List<BaseFunction> findBys(BaseFunction baseFunction, BaseModule baseModule);

    List<BaseFunction> findByMid(Integer mid, Integer userId);
}