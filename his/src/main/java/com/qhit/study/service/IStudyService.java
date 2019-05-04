package com.qhit.study.service;

import java.util.List;
import com.qhit.study.pojo.Study;
/**
* Created by GeneratorCode on 2018/12/26
*/

public interface IStudyService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Study findById(Object id);

    List<Study> search(Study study);

}