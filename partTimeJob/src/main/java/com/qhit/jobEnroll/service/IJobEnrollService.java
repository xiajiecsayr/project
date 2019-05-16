package com.qhit.jobEnroll.service;

import java.util.List;
import com.qhit.jobEnroll.pojo.JobEnroll;
/**
* Created by GeneratorCode on 2019/05/08
*/
public interface IJobEnrollService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    JobEnroll findById(Object id);

    List<JobEnroll> search(JobEnroll jobEnroll);

}