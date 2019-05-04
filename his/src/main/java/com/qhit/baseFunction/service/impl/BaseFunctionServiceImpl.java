package com.qhit.baseFunction.service.impl;

import com.qhit.baseFunction.service.IBaseFunctionService;
import java.util.List;
import com.qhit.baseFunction.dao.IBaseFunctionDao;
import com.qhit.baseFunction.dao.impl.BaseFunctionDaoImpl;
import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseModule.pojo.BaseModule;

/**
* Created by GeneratorCode on 2018/11/28
*/

public class BaseFunctionServiceImpl  implements IBaseFunctionService {

    IBaseFunctionDao dao = new BaseFunctionDaoImpl();

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
        BaseFunction baseFunction = findById(id); 
        return dao.delete(baseFunction); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseFunction findById(Object id) { 
        List<BaseFunction> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<com.qhit.baseFunction.controller.BaseFunctions> findAlls() {
        String sql = "SELECT * from base_function bf left JOIN base_module bm ON bf.mid=bm.mid";
        return dao.freeFind(sql);
    }

   /* @Override
    public List<BaseFunction> findByMid(Integer mid) {
        if(mid==null){
            mid=1;
        }
        return dao.findByMid(mid);
    }*/
   @Override
   public List<BaseFunction> findByMid(Integer mid, Integer userId) {
       if(mid==null){
           mid=1;
       }
       String sql = "SELECT DISTINCT bf.*\n" +
               "from base_function bf JOIN base_role_function brf ON bf.fid=brf.fid\n" +
               "\t\t      JOIN base_role br ON brf.rid=br.rid\n" +
               "\t\t      JOIN base_user_role bur ON bur.rid = br.rid\n" +
               "\t\t      JOIN base_user bu ON bu.user_id = bur.uid\n" +
               "\t\t      JOIN base_module bm ON bm.mid = bf.mid\n" +
               "\t\t      AND bur.uid="+userId+"\n" +
               "\t\t      AND bf.mid="+mid;
       return dao.freeFind(sql);
   }
    @Override
    public List<BaseFunction> findBys(BaseFunction baseFunction, BaseModule baseModule) {
        String sql = "SELECT * from base_function bf JOIN base_module bm ON bf.mid=bm.mid ";
        String str ="where 1=1";
        if(baseFunction.getFname()!=null && !"".equals(baseFunction.getFname())){
            str+=" and bf.fname like '%"+baseFunction.getFname()+"%'";
        }
        if(baseModule.getMname()!=null && !"".equals(baseModule.getMname())){
            str+=" and bm.mname like '%"+baseModule.getMname()+"%'";
        }
        if(baseFunction.getUrl()!=null && !"".equals(baseFunction.getUrl())){
            str+=" and bf.url like '%"+baseFunction.getUrl()+"%'";
        }
        return dao.freeFind(sql + str);
    }




}