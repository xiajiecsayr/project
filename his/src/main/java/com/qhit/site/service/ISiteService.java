package com.qhit.site.service;

import java.util.List;
import com.qhit.site.pojo.Site;
/**
* Created by GeneratorCode on 2018/12/26
*/

public interface ISiteService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Site findById(Object id);

    List<Site> search(Site site);

}