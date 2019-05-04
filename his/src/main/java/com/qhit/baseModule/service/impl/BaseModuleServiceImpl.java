package com.qhit.baseModule.service.impl;

import com.qhit.baseModule.service.IBaseModuleService;
import java.util.List;
import com.qhit.baseModule.dao.IBaseModuleDao;
import com.qhit.baseModule.dao.impl.BaseModuleDaoImpl;
import com.qhit.baseModule.pojo.BaseModule;

/**
* Created by GeneratorCode on 2018/11/28
*/

public class BaseModuleServiceImpl  implements IBaseModuleService {

    IBaseModuleDao dao = new BaseModuleDaoImpl();

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
        BaseModule baseModule = findById(id); 
        return dao.delete(baseModule); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseModule findById(Object id) { 
        List<BaseModule> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<BaseModule> find(String mname) {
        String sql = "select * from base_module where mname like '%"+mname+"%'";
        return dao.freeFind(sql);
    }

    @Override
    public BaseModule findBymname(String mname) {
        String sql = "select * from base_module where mname = '"+mname+"'";
        List<BaseModule> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }


}