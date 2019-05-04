package com.qhit.baseUserRole.service.impl;

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUserRole.service.IBaseUserRoleService;
import java.util.List;
import com.qhit.baseUserRole.dao.IBaseUserRoleDao;
import com.qhit.baseUserRole.dao.impl.BaseUserRoleDaoImpl;
import com.qhit.baseUserRole.pojo.BaseUserRole;

/**
* Created by GeneratorCode on 2018/11/30
*/

public class BaseUserRoleServiceImpl  implements IBaseUserRoleService {

    IBaseUserRoleDao dao = new BaseUserRoleDaoImpl();

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
        BaseUserRole baseUserRole = findById(id); 
        return dao.delete(baseUserRole); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseUserRole findById(Object id) { 
        List<BaseUserRole> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }

    @Override
    public List<BaseUserRole> findSAll() {
        String sql = "SELECT* from base_user_role bur JOIN base_role br ON bur.rid=br.rid\n" +
                "\t\t\t\tJOIN base_user bu ON bur.uid=bu.user_id WHERE br.rname='医生'";
        return dao.freeFind(sql);
    }

    @Override
    public  List<BaseUserRole> findSname(Integer yisheng) {
        String sql = "SELECT* from base_user_role bur JOIN base_role br ON bur.rid=br.rid\n" +
                "\t\t\t\tJOIN base_user bu ON bur.uid=bu.user_id\n" +
                "\t\t\t\tWHERE bu.user_id='"+yisheng+"'";
        return dao.freeFind(sql);
    }


}