package com.qhit.energyConsume.service;

import java.util.List;
import java.util.Map;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.produceReport.pojo.ProduceReport;

/**
* Created by GeneratorCode on 2019/04/10
*/
public interface IEnergyConsumeService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    EnergyConsume findById(Object id);

    List<EnergyConsume> search(EnergyConsume energyConsume);

    //记录能耗
    boolean insert(ProduceReport produceReport, BaseFlow baseFlow);
    Map<String,Object> model(String year, Integer compid);
}