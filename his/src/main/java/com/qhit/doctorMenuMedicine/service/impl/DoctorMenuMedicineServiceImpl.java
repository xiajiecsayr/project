package com.qhit.doctorMenuMedicine.service.impl;

import com.qhit.doctorMenuMedicine.service.IDoctorMenuMedicineService;
import java.util.List;
import com.qhit.doctorMenuMedicine.dao.IDoctorMenuMedicineDao;
import com.qhit.doctorMenuMedicine.dao.impl.DoctorMenuMedicineDaoImpl;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import com.qhit.medicineStockinfo.pojo.MedicineStockinfo;
import com.qhit.medicineStockinfo.service.IMedicineStockinfoService;
import com.qhit.medicineStockinfo.service.impl.MedicineStockinfoServiceImpl;

/**
* Created by GeneratorCode on 2018/12/19
*/

public class DoctorMenuMedicineServiceImpl  implements IDoctorMenuMedicineService {

    IDoctorMenuMedicineDao dao = new DoctorMenuMedicineDaoImpl();

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
        DoctorMenuMedicine doctorMenuMedicine = findById(id); 
        return dao.delete(doctorMenuMedicine); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorMenuMedicine findById(Object id) { 
        List<DoctorMenuMedicine> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<DoctorMenuMedicine> search(DoctorMenuMedicine doctorMenuMedicine) {
            String sql = "select * from doctor_menu_medicine where 1=1 "; 
            if (doctorMenuMedicine.getMenuId()!=null && !"".equals(doctorMenuMedicine.getMenuId())){        
                sql+=" and menu_id like '%"+doctorMenuMedicine.getMenuId()+"%' ";        
            } 
            if (doctorMenuMedicine.getCodeId()!=null && !"".equals(doctorMenuMedicine.getCodeId())){        
                sql+=" and code_id like '%"+doctorMenuMedicine.getCodeId()+"%' ";        
            } 
            if (doctorMenuMedicine.getAmt()!=null && !"".equals(doctorMenuMedicine.getAmt())){        
                sql+=" and amt like '%"+doctorMenuMedicine.getAmt()+"%' ";        
            } 
            List<DoctorMenuMedicine> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public void distributeUpdate(Integer menuId, String fid) {
        //拆分rid
        String[] arr = fid.substring(0, fid.length() - 1).split(",");
        //        删除doctor_menu_medicine表中所有menuId记录
        IDoctorMenuMedicineService doctorMenuMedicineService = new DoctorMenuMedicineServiceImpl();
        String  delSql = "delete from doctor_menu_medicine where menu_id = "+menuId;
        doctorMenuMedicineService.freeUpdate(delSql);
        IMedicineStockinfoService medicineStockinfoService = new MedicineStockinfoServiceImpl();
//        批量插入
        for(String mid:arr){
            DoctorMenuMedicine doctorMenuMedicine = new DoctorMenuMedicine();
            doctorMenuMedicine.setCodeId(Integer.parseInt(mid));
            doctorMenuMedicine.setMenuId(menuId);
            MedicineStockinfo medicineStockinfo = medicineStockinfoService.findByMid(mid);
            doctorMenuMedicine.setAmt(medicineStockinfo.getAmt());
            doctorMenuMedicineService.insert(doctorMenuMedicine);
        }
    }

    @Override
    public List<DoctorMenuMedicine> findSAll() {
        String sql = "SELECT * from doctor_menu_medicine dmm JOIN doctor_menu dm\n" +
                "\t\t\t\t\tON dmm.menu_id=dm.menu_id\n" +
                "\t\t\t\t\tJOIN medicine_code mc \n" +
                "\t\t\t\t\tON mc.code_id=dmm.code_id";
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenuMedicine> findMenuMedicine(Integer $inp3) {
        String sql = "SELECT * from doctor_menu_medicine WHERE menu_id='"+$inp3+"'";
        return dao.freeFind(sql);
    }

    @Override
    public List<DoctorMenuMedicine> findmaintainAll(Integer $opp) {
        String sql = "SELECT * from doctor_menu_medicine dmm JOIN doctor_menu dm \n" +
                "\t\t\t\t       ON dmm.menu_id=dm.menu_id\n" +
                "\t\t\t\t       JOIN medicine_code mc \n" +
                "\t\t\t\t       ON dmm.code_id=mc.code_id\n" +
                "\t\t\t\t       WHERE dmm.menu_id='"+$opp+"'";
        return dao.freeFind(sql);
    }


}