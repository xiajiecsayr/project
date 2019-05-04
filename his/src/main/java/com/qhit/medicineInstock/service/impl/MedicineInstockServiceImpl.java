package com.qhit.medicineInstock.service.impl;

import com.qhit.medicineInstock.service.IMedicineInstockService;
import java.util.List;
import com.qhit.medicineInstock.dao.IMedicineInstockDao;
import com.qhit.medicineInstock.dao.impl.MedicineInstockDaoImpl;
import com.qhit.medicineInstock.pojo.MedicineInstock;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineStockinfo.pojo.MedicineStockinfo;

/**
* Created by GeneratorCode on 2018/12/12
*/

public class MedicineInstockServiceImpl  implements IMedicineInstockService {
    IMedicineInstockDao dao = new MedicineInstockDaoImpl();

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
        MedicineInstock medicineInstock = findById(id); 
        return dao.delete(medicineInstock); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public MedicineInstock findById(Object id) { 
        List<MedicineInstock> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicineInstock> search(MedicineInstock medicineInstock) {
            String sql = "select * from medicine_instock where 1=1 "; 
            if (medicineInstock.getInvno()!=null && !"".equals(medicineInstock.getInvno())){        
                sql+=" and invno like '%"+medicineInstock.getInvno()+"%' ";        
            } 
            if (medicineInstock.getMedicineCodeid()!=null && !"".equals(medicineInstock.getMedicineCodeid())){        
                sql+=" and medicine_codeid like '%"+medicineInstock.getMedicineCodeid()+"%' ";        
            } 
            if (medicineInstock.getInamt()!=null && !"".equals(medicineInstock.getInamt())){        
                sql+=" and inamt like '%"+medicineInstock.getInamt()+"%' ";        
            } 
            if (medicineInstock.getUnitprc()!=null && !"".equals(medicineInstock.getUnitprc())){        
                sql+=" and unitprc like '%"+medicineInstock.getUnitprc()+"%' ";        
            } 
            if (medicineInstock.getZje()!=null && !"".equals(medicineInstock.getZje())){        
                sql+=" and zje like '%"+medicineInstock.getZje()+"%' ";        
            } 
            if (medicineInstock.getInstockUserid()!=null && !"".equals(medicineInstock.getInstockUserid())){        
                sql+=" and instock_userid like '%"+medicineInstock.getInstockUserid()+"%' ";        
            } 
            if (medicineInstock.getInstockDate()!=null && !"".equals(medicineInstock.getInstockDate())){        
                sql+=" and instock_date like '%"+medicineInstock.getInstockDate()+"%' ";        
            } 
            if (medicineInstock.getManCode()!=null && !"".equals(medicineInstock.getManCode())){        
                sql+=" and man_code like '%"+medicineInstock.getManCode()+"%' ";        
            } 
            List<MedicineInstock> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public MedicineStockinfo ifID(MedicinePurchaseInfo medicinePurchaseInfo1) {
        String sql = "SELECT * from medicine_stockinfo WHERE medicinecode_id ='"+medicinePurchaseInfo1.getMedicineCodeid()+"'";
        List<MedicineStockinfo> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<MedicineInstock> findSAll() {
        String sql = "SELECT * from medicine_instock mi JOIN base_manufacturer bm ON mi.man_code = bm.man_Code";
        return dao.freeFind(sql);
    }


}