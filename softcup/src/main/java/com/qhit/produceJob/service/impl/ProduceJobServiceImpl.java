package com.qhit.produceJob.service.impl;

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.produceJob.pojo.ChartData2;
import com.qhit.produceJob.service.IProduceJobService;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.qhit.produceJob.dao.IProduceJobDao;
import com.qhit.produceJob.pojo.ProduceJob;
import com.qhit.produceReport.pojo.ProduceReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2019/04/10
*/

@Service 
public class ProduceJobServiceImpl  implements IProduceJobService {

    @Resource 
    IProduceJobDao dao;

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
        ProduceJob produceJob = findById(id); 
        return dao.delete(produceJob); 
    } 

    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 

    @Override 
    public ProduceJob findById(Object id) { 
        List<ProduceJob> list = dao.findById(id); 
        return  list.get(0); 
    } 

    @Override 
    public List<ProduceJob> search(ProduceJob produceJob) {
        return dao.search(produceJob); 
    }
    //记录作业
    @Override
    public boolean insert(ProduceReport produceReport,BaseFlow baseFlow) {
        SimpleDateFormat startjobtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat completetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double duration;
        try {
            long time = completetime.parse(produceReport.getCompletetime()).getTime()-startjobtime.parse(produceReport.getStartjobtime()).getTime();
            duration = (double)time/3600000;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
//        设置需要保留的几位小数
        DecimalFormat df = new DecimalFormat("#.##");
        ProduceJob produceJob1 = new ProduceJob();
        ProduceJob produceJob2 = new ProduceJob();
        ProduceJob produceJob3 = new ProduceJob();
        double f = Double.valueOf(String.valueOf(produceReport.getCapacity()))/10;
//       ----------------斗轮机
        produceJob1.setDevid(baseFlow.getDljid());
        produceJob1.setStarttime(produceReport.getStartjobtime());
        produceJob1.setCompletetime(produceReport.getCompletetime());
        produceJob1.setDuration(Double.valueOf(df.format(duration)));
        produceJob1.setAmount(f*4);
        produceJob1.setReportid(produceReport.getReportid());
//        ---------------装船机
        produceJob2.setDevid(baseFlow.getZcjid());
        produceJob2.setStarttime(produceReport.getStartjobtime());
        produceJob2.setCompletetime(produceReport.getCompletetime());
        produceJob2.setDuration(Double.valueOf(df.format(duration)));
        produceJob2.setAmount(f*4);
        produceJob2.setReportid(produceReport.getReportid());
//        ---------------皮带机
        produceJob3.setDevid(baseFlow.getPdjid());
        produceJob3.setStarttime(produceReport.getStartjobtime());
        produceJob3.setCompletetime(produceReport.getCompletetime());
        produceJob3.setDuration(Double.valueOf(df.format(duration)));
        produceJob3.setAmount(f*2);
        produceJob3.setReportid(produceReport.getReportid());

        dao.insert(produceJob1);
        dao.insert(produceJob2);
        dao.insert(produceJob3);

        return true;
    }

    @Override
    public Map<String,Object> model(String year, Integer compid) {
        Map<String,Object> map = new HashMap<>();
        map.put("year",year);
        map.put("compid",compid);
        //查询港口数据
        List<ChartData2> companyList = dao.findCompByCompid(map);
        //定义前端需要的数据（map）
        Map<String,Object> data1 = new HashMap<>();
        if(companyList!=null && companyList.size()>0){
            ChartData2 company = companyList.get(0);
            String compname = company.getComp();
            String companyAmount = company.getAmount();
            data1.put("name",compname);
            data1.put("value",companyAmount);
            List<Map<String,Object>> flowList = new ArrayList<>();//定义港口children map

            //查询改港口所有流程
            List<ChartData2> flows = dao.findAllFlowByCompid(map);
            for (int i = 0; i < flows.size(); i++) {//循环当前港口所有流程
                ChartData2 flow = flows.get(i);
                Integer flowid = flow.getFlowid();//flowid
                String flowname = flow.getFlow();//flowname
                String flowAmount = flow.getAmount();
                Map<String,Object> flowMap = new HashMap<>();//定义流程map
                flowMap.put("name",flowname);
                flowMap.put("value",flowAmount);
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