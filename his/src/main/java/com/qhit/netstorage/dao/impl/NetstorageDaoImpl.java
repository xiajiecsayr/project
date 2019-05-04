package com.qhit.netstorage.dao.impl;

import com.qhit.netstorage.dao.INetstorageDao;
import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/20
*/

public class NetstorageDaoImpl extends BaseDao implements INetstorageDao {

    @Override
    public List findAll() { 
        String sql = "select * from netstorage"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from netstorage where fileId='"+id+"'"; 
        return freeFind(sql); 
    }


    @Override 
    public List findByFilename(Object filename) { 
        String sql = "select * from netstorage where fileName='"+filename+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByFilesize(Object filesize) { 
        String sql = "select * from netstorage where fileSize='"+filesize+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUploaddate(Object uploaddate) { 
        String sql = "select * from netstorage where upLoadDate='"+uploaddate+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUid(Object uid) { 
        String sql = "select * from netstorage where uid='"+uid+"'"; 
        return freeFind(sql); 
    } 




}