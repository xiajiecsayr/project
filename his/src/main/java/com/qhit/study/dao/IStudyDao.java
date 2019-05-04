package com.qhit.study.dao;

import org.springframework.stereotype.Repository;
import com.qhit.study.pojo.Study;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/26
*/

@Repository  
public interface IStudyDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Study> search(Study study);

    List findBySName(Object sName);

    List findBySSex(Object sSex);

    List findBySAge(Object sAge);

    List findBySSiteid(Object sSiteid);

}