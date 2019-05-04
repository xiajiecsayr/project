package com.qhit.produceReport.controller; 

import com.qhit.baseFlow.pojo.BaseFlow;
import com.qhit.baseFlow.service.IBaseFlowService;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.energyConsume.service.IEnergyConsumeService;
import com.qhit.produceJob.service.IProduceJobService;
import com.qhit.produceReport.pojo.ProduceReport;
import com.qhit.produceReport.service.IProduceReportService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RestController; 

/** 
* Created by GeneratorCode on 2019/04/08
*/ 

@RestController 
@RequestMapping("/produceReport") 
public class ProduceReportController { 

    @Resource 
    IProduceReportService produceReportService;
    @Resource
    IBaseFlowService baseFlowService;
    @Resource
    IProduceJobService produceJobService;
    @Resource
    IEnergyConsumeService energyConsumeService;

    @RequestMapping("/insert") 
    public void insert(ProduceReport produceReport) { 
        produceReportService.insert(produceReport); 
    } 

    @RequestMapping("/delete") 
    public void delete(Integer reportid) { 
        produceReportService.delete(reportid); 
    } 

    @RequestMapping("/update") 
    public void update(ProduceReport produceReport) { 
        produceReportService.update(produceReport); 
    } 

    @RequestMapping("/updateSelective") 
    public List<ProduceReport> updateSelective(ProduceReport produceReport) {
        produceReportService.updateSelective(produceReport);
        return list();
    } 

    @RequestMapping("/load") 
    public ProduceReport load(Integer reportid) { 
        ProduceReport produceReport = produceReportService.findById(reportid); 
        return produceReport; 
    } 

    @RequestMapping("/list") 
    public List<ProduceReport> list()  { 
        List<ProduceReport> list = produceReportService.findAll(); 
        return list; 
    } 

    @RequestMapping("/search") 
    public List<ProduceReport> search(ProduceReport produceReport) { 
        List<ProduceReport> list = produceReportService.search(produceReport); 
        return list; 
    }

    @RequestMapping(value = "/completeTask")
    @Transactional
    public List<ProduceReport> completeTask(ProduceReport produceReport){
//        开发compoleteTask方法  接收参数：reportid,flowid,startjobtime,completetime
//        将获取的参数赋值给produceReport1对象
//        获取对应流程的设备
        BaseFlow baseFlow = baseFlowService.findById(produceReport.getFlowid());
//        更改数据
        produceReportService.updateSelective(produceReport);
        produceJobService.insert(produceReport,baseFlow);
        energyConsumeService.insert(produceReport,baseFlow);
        return list();
    }

    @RequestMapping(value = "/init")
    public void init(HttpSession session){
//      初始化报岗表
        ProduceReport produceReport = new ProduceReport();
        Random random = new Random();
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUser");
        List<BaseFlow> flows = baseFlowService.findByCompid(baseUser.getCompid());
//        船队名称
        String shipname = "lh-船A";
        int flowIndex = 0;
        int count=0;
        String[] year = {"2018","2019"};
        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        int yearIndex=0;
        int monthIndex=0;
        for (int i = 101; i <=132 ; i++) {
            produceReport.setShipname(shipname+i);  //船队名称
            produceReport.setCapacity(0f+random.nextInt(100)+150);  //装载量
            count++;
            if(count%17==0) flowIndex++;
            produceReport.setFlowid(flows.get(flowIndex).getFlowid());  //流程id
            produceReport.setReportuser("王文政");
            produceReport.setCompid(2);

            if((i-100)%17<=12){
                yearIndex=0;
            }else{
                yearIndex=1;
            }
            if((i-100)%16==1 || (i-100)%16==13){
                monthIndex=0;
            }else{
                monthIndex++;
            }
            String startjobtime = year[yearIndex]+"-"+month[monthIndex]+"-04"+" "+random.nextInt(5)+":00:00";
            String completetime = year[yearIndex]+"-"+month[monthIndex]+"-04"+" "+(random.nextInt(5)+8)+":"+random.nextInt(60)+":00";
            produceReport.setPlanjobtime(startjobtime);
            produceReport.setStartjobtime(startjobtime);
            produceReport.setCompletetime(completetime);
            produceReportService.insert(produceReport);
        }
        List<ProduceReport> list = produceReportService.findByCompid(baseUser.getCompid());
        for(ProduceReport pr:list){
            completeTask(pr);
        }
    }

} 
