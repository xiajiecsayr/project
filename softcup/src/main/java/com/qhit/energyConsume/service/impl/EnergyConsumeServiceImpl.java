package com.qhit.energyConsume.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.energyConsume.service.IEnergyConsumeService;

import java.text.DecimalFormat;
import java.util.*;

import com.qhit.energyConsume.dao.IEnergyConsumeDao;
import com.qhit.energyConsume.pojo.EnergyConsume;
import com.qhit.produceJob.pojo.ChartData3;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class EnergyConsumeServiceImpl  implements IEnergyConsumeService {

    @Resource 
    IEnergyConsumeDao dao;

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
        EnergyConsume energyConsume = findById(id); 
        return dao.delete(energyConsume); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public EnergyConsume findById(Object id) { 
        List<EnergyConsume> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<EnergyConsume> search(EnergyConsume energyConsume) { 
        return dao.search(energyConsume); 
    }

    //记录能耗
    @Override
    public boolean insert(ProduceReport produceReport, BaseFlow baseFlow) {
        //定义random便于生产随机数
        Random random = new Random();
//        --------------------------------------
        //设置需要保留的几位小数
        DecimalFormat df = new DecimalFormat("#.##");
        //工作量
        double f = Double.valueOf(String.valueOf(produceReport.getCapacity()))/10;
        //插入数据
        //声明对象
        EnergyConsume energyConsume1 = new EnergyConsume();
        EnergyConsume energyConsume2 = new EnergyConsume();
        EnergyConsume energyConsume3 = new EnergyConsume();
//        --------------斗轮机
        energyConsume1.setDevid(baseFlow.getDljid());
        energyConsume1.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*4)));
        energyConsume1.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*4)));
        energyConsume1.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*4)));
        energyConsume1.setReportid(produceReport.getReportid());
//        --------------装船机
        energyConsume2.setDevid(baseFlow.getZcjid());
        energyConsume2.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*4)));
        energyConsume2.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*4)));
        energyConsume2.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*4)));
        energyConsume2.setReportid(produceReport.getReportid());

//        --------------皮带机
        energyConsume3.setDevid(baseFlow.getPdjid());
        energyConsume3.setElectric(Double.valueOf(df.format((random.nextInt(201)+100)*f*2)));
        energyConsume3.setWater(Double.valueOf(df.format((random.nextInt(10)+1)*f*2)));
        energyConsume3.setOil(Double.valueOf(df.format((random.nextInt(31)+10)*f*2)));
        energyConsume3.setReportid(produceReport.getReportid());
        dao.insert(energyConsume1);
        dao.insert(energyConsume2);
        dao.insert(energyConsume3);
        return true;
    }

    @Override
    public Map<String, Object> model(String year, Integer compid) {
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        map.put("compid",compid);
        //查询港口数据
        List<ChartData3> companyList = dao.findCompByCompid(map);
        //定义前端需要的数据（map）
        Map<String,Object> data1 = new HashMap<>();
        if(companyList!=null && companyList.size()>0){
            ChartData3 company = companyList.get(0);
            String comp = company.getComp();
            String companyConsume = company.getConsume();
            data1.put("comp",comp);
            data1.put("consume",companyConsume);
            List<Map<String,Object>> flowList = new ArrayList<>();//定义港口children map
            //查询改港口所有流程
            List<ChartData3> flows = dao.findAllFlowByCompid(map);
            for (int i = 0; i < flows.size(); i++) {//循环当前港口所有流程
                ChartData3 flow = flows.get(i);
                Integer flowid = flow.getFlowid();//flowid
                String flowname = flow.getFlow();//flowname
                String flowConsume = flow.getConsume();
                Map<String,Object> flowMap = new HashMap<>();//定义流程map
                flowMap.put("flow",flowname);
                flowMap.put("consume",flowConsume);
                //条件map 添加flowid，通过港口id&&流程id&&年份 查询设备数据
                map.put("flowid",flowid);
                List<Map> devs = dao.findAllDevByFlowid(map);
                flowMap.put("children",devs);//把设备信息添加到 流程.children
                flowList.add(flowMap);//把设备信息(map)添加到流程list中
            }
            data1.put("children",flowList);//把把流程信息(list)添加到data1.children
        }

        return data1;
    }
}