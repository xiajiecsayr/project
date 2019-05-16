package com.qhit.jobComment.dao;

import org.apache.ibatis.annotations.Mapper;
import com.qhit.jobComment.pojo.JobComment;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/05/08
*/

@Mapper  
public interface IJobCommentDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<JobComment> search(JobComment jobComment);

    List findByUserId(Object userId);

    List findByJobId(Object jobId);

    List findByJcContent(Object jcContent);

    List findByJcTime(Object jcTime);

    List findByFabulouscount(Object fabulouscount);

}