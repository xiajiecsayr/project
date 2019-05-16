package com.qhit.jobComment.service;

import java.util.List;
import com.qhit.jobComment.pojo.JobComment;
/**
* Created by GeneratorCode on 2019/05/08
*/
public interface IJobCommentService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    JobComment findById(Object id);

    List<JobComment> search(JobComment jobComment);

}