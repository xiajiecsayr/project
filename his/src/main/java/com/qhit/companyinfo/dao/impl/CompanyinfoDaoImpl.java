package com.qhit.companyinfo.dao.impl;

import com.qhit.companyinfo.dao.ICompanyinfoDao;
import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/05
*/

public class CompanyinfoDaoImpl extends BaseDao implements ICompanyinfoDao {

    @Override
    public boolean insert(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean updateSelective(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List freeFind(String sql) {
        return null;
    }

    @Override
    public List findAll() { 
        String sql = "select * from companyinfo"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from companyinfo where cid='"+id+"'"; 
        return freeFind(sql); 
    }

    @Override
    public boolean freeUpdate(String sql) {
        return false;
    }


    @Override 
    public List findByCompname(Object compname) { 
        String sql = "select * from companyinfo where compname='"+compname+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByOwnername(Object ownername) { 
        String sql = "select * from companyinfo where ownername='"+ownername+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByOwnertel(Object ownertel) { 
        String sql = "select * from companyinfo where ownertel='"+ownertel+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByCompinfo(Object compinfo) { 
        String sql = "select * from companyinfo where compinfo='"+compinfo+"'"; 
        return freeFind(sql); 
    } 




}