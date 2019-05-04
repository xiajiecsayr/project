package com.qhit.users.dao.impl;

import com.qhit.users.dao.IUsersDao;
import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/20
*/

public class UsersDaoImpl extends BaseDao implements IUsersDao {

    @Override
    public List findAll() { 
        String sql = "select * from users"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from users where uid='"+id+"'"; 
        return freeFind(sql); 
    }


    @Override 
    public List findByUname(Object uname) { 
        String sql = "select * from users where uname='"+uname+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPwd(Object pwd) { 
        String sql = "select * from users where pwd='"+pwd+"'"; 
        return freeFind(sql); 
    } 




}