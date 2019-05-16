package com.qhit.job.dao;

import com.qhit.job.pojo.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/** 
* Created by GeneratorCode on 2019/05/05
*/

@Mapper
public interface IJobDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findOfManage();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Job> search(Job job);

    List<Job> searchOfManage(Job job);

    List findByJobContent(Object jobContent);

    List findByJobTime(Object jobTime);

    List findByJobState(Object jobState);

    List findByUserId(Object userId);

    List findByAddress(Object address);

    List findByJobName(Object jobName);

    List findByJobTel(Object jobTel);

    List findByExastate(Object exastate);

    List findByJobCount(Object jobCount);

}