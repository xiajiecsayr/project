package com.qhit.baseDevice.service.impl;

import com.qhit.baseDevice.service.IBaseDeviceService;
import java.util.List;
import com.qhit.baseDevice.dao.IBaseDeviceDao;
import com.qhit.baseDevice.pojo.BaseDevice;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/04/08
*/

@Service 
public class BaseDeviceServiceImpl  implements IBaseDeviceService {

    @Resource 
    IBaseDeviceDao dao;

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
        BaseDevice baseDevice = findById(id); 
        return dao.delete(baseDevice); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public BaseDevice findById(Object id) { 
        List<BaseDevice> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<BaseDevice> search(BaseDevice baseDevice) { 
        return dao.search(baseDevice); 
    }

    @Override
    public List<BaseDevice> findDevice(Integer compid, int i) {
        List<BaseDevice> list= dao.findDevice(compid,i);
        return list;
    }

    @Override
    public List<BaseDevice> findByCompid(Integer compid) {
        return dao.findByCompid(compid);
    }


}