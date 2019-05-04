package com.qhit.medicinePurchaseInfo.service;

import java.util.List;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* Created by GeneratorCode on 2018/12/06
*/

public interface IMedicinePurchaseInfoService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(MedicinePurchaseInfo medicinePurchaseInfo);
    boolean  updateSelectives(Object object);

    boolean delete(Object id);

    List findAll();

    MedicinePurchaseInfo findById(Object id);

    boolean freeUpdate(String sql);

    List<MedicinePurchaseInfo> search(MedicinePurchaseInfo medicinePurchaseInfo);

    void collect(HttpSession session);

    List<MedicinePurchaseInfo> findSAll();

    List<MedicineReqPlan> collects();

    MedicinePurchaseInfo findByusernme(Integer pchUserid);

    List<MedicinePurchaseInfo> findSSAll();

    MedicinePurchaseInfo findByCodeid(MedicineReqPlan medicineReqPlan);

    MedicinePurchaseInfo findBySta(MedicinePurchaseInfo medicinePurchaseInfo, MedicineReqPlan reqPlan);
}