package com.qhit.site.dao;

import org.springframework.stereotype.Repository;
import com.qhit.site.pojo.Site;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/26
*/

@Repository  
public interface ISiteDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<Site> search(Site site);

    List findByMSite(Object mSite);

}