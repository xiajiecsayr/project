package com.qhit.site.service.impl;

import com.qhit.site.service.ISiteService;
import java.util.List;
import com.qhit.site.dao.ISiteDao;
import com.qhit.site.pojo.Site;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/26
*/

@Service 
public class SiteServiceImpl  implements ISiteService {

    @Resource 
    ISiteDao dao;

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        Site site = findById(id); 
        return dao.delete(site); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Site findById(Object id) { 
        List<Site> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Site> search(Site site) { 
        return dao.search(site); 
    } 


}