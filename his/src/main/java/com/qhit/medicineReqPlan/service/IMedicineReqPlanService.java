package com.qhit.medicineReqPlan.service;

import java.util.List;

import com.qhit.medicineCode.pojo.MedicineCode;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
/**
* Created by GeneratorCode on 2018/12/06
*/

public interface IMedicineReqPlanService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    MedicineReqPlan findById(Object id);

    boolean freeUpdate(String sql);

    List<MedicineReqPlan> search(MedicineReqPlan medicineReqPlan,String medicineName);

    List<MedicineReqPlan> findByUserId(Integer userId);

    MedicineReqPlan findBymrp(Integer medicineCodeid);
}