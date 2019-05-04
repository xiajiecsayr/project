package com.qhit.medicineInstock.service;

import java.util.List;
import com.qhit.medicineInstock.pojo.MedicineInstock;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineStockinfo.pojo.MedicineStockinfo;

/**
* Created by GeneratorCode on 2018/12/12
*/

public interface IMedicineInstockService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    MedicineInstock findById(Object id);

    boolean freeUpdate(String sql);

    List<MedicineInstock> search(MedicineInstock medicineInstock);

    MedicineStockinfo ifID(MedicinePurchaseInfo medicinePurchaseInfo1);

    List<MedicineInstock> findSAll();
}