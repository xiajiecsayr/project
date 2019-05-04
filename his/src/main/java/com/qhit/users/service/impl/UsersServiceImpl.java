package com.qhit.users.service.impl;

import com.qhit.users.service.IUsersService;
import java.util.List;
import com.qhit.users.dao.IUsersDao;
import com.qhit.users.dao.impl.UsersDaoImpl;
import com.qhit.users.pojo.Users;
import com.qhit.utils.MD5;

/**
* Created by GeneratorCode on 2018/12/20
*/

public class UsersServiceImpl  implements IUsersService {

    IUsersDao dao = new UsersDaoImpl();

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
        Users users = findById(id); 
        return dao.delete(users); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Users findById(Object id) { 
        List<Users> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<Users> search(Users users) {
            String sql = "select * from users where 1=1 "; 
            if (users.getUname()!=null && !"".equals(users.getUname())){        
                sql+=" and uname like '%"+users.getUname()+"%' ";        
            } 
            if (users.getPwd()!=null && !"".equals(users.getPwd())){        
                sql+=" and pwd like '%"+users.getPwd()+"%' ";        
            } 
            List<Users> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public Users login(String userName,String password) {
        String sql = "SELECT * from users WHERE uname = '"+userName+"' AND pwd ='"+password+"'";
        List<Users> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }


}