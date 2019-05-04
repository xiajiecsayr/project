package com.qhit.users.service;

import java.util.List;
import com.qhit.users.pojo.Users;
/**
* Created by GeneratorCode on 2018/12/20
*/

public interface IUsersService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Users findById(Object id);

    boolean freeUpdate(String sql);

    List<Users> search(Users users);

    Users login(String userName,String password);
}