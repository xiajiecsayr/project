package com.qhit.jobEnroll.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.jobEnroll.pojo.JobEnroll;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/05/08
*/

@Mapper  
public interface IJobEnrollDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<JobEnroll> search(JobEnroll jobEnroll);

    List findByUserId(Object userId);

    List findByJobId(Object jobId);

}