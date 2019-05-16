package com.qhit.job.service;

import com.qhit.job.pojo.Job;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
* Created by GeneratorCode on 2019/05/05
*/
public interface IJobService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Job findById(Object id);

    List<Job> search(Job job);

    List<Job> searchOfManage(Job job);

    List findOfManage();

     Map getUesr(HttpSession session);

}