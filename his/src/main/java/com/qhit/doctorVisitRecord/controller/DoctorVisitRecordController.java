package com.qhit.doctorVisitRecord.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import com.qhit.doctorMenuMedicine.service.IDoctorMenuMedicineService;
import com.qhit.doctorMenuMedicine.service.impl.DoctorMenuMedicineServiceImpl;
import com.qhit.doctorVisitRecord.pojo.DoctorVisitRecord;
import com.qhit.doctorVisitRecord.service.IDoctorVisitRecordService; 
import com.qhit.doctorVisitRecord.service.impl.DoctorVisitRecordServiceImpl;
import com.qhit.doctorVisitRecordinfo.pojo.DoctorVisitRecordinfo;
import com.qhit.doctorVisitRecordinfo.service.IDoctorVisitRecordinfoService;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
import com.qhit.patientRegisterRecord.service.IPatientRegisterRecordService;
import com.qhit.patientRegisterRecord.service.impl.PatientRegisterRecordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException;
import java.util.Date;
import java.util.List;

/** 
* Created by GeneratorCode on 2018/12/28
*/ 

@Controller 
@RequestMapping("/doctorVisitRecord")
public class DoctorVisitRecordController { 

    @Resource 
    IDoctorVisitRecordService doctorVisitRecordService;
    IPatientRegisterRecordService patientRegisterRecordService = new PatientRegisterRecordServiceImpl();
    IDoctorMenuMedicineService doctorMenuMedicineService = new DoctorMenuMedicineServiceImpl();
    @Resource
    IDoctorVisitRecordinfoService doctorVisitRecordinfoService;

    @RequestMapping("/insert") 
    public String insert(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.insert(doctorVisitRecord); 
        return "forward:listall.action";
    }
    @RequestMapping("/insertall")
    public String insertall(DoctorVisitRecord doctorVisitRecord,HttpSession session,Integer $patientId,String $inp1,String $inp2,Integer $inp3) {
        BaseUser baseUser = (BaseUser) session.getAttribute("sessionUser");
        doctorVisitRecord.setPatientId($patientId);
        doctorVisitRecord.setDoctorId(baseUser.getUserId());
        doctorVisitRecord.setVisitDate(CommonUtil.dateToStr(new Date()));
        doctorVisitRecord.setSymptom($inp1);
        doctorVisitRecord.setAdvice($inp2);
        doctorVisitRecord.setStatus(1);
        doctorVisitRecordService.insert(doctorVisitRecord);
        List<DoctorMenuMedicine> list = doctorMenuMedicineService.findMenuMedicine($inp3);
        DoctorVisitRecordinfo doctorVisitRecordinfo = new DoctorVisitRecordinfo();
        DoctorVisitRecord doctorVisitRecord1 = new DoctorVisitRecord();
        for (DoctorMenuMedicine doctorMenuMedicine:list) {
            doctorVisitRecordinfo.setVrId(doctorVisitRecord1.getVrId());
            doctorVisitRecordinfo.setCodeId(doctorMenuMedicine.getCodeId());
            doctorVisitRecordinfo.setAmt(doctorMenuMedicine.getAmt());
            doctorVisitRecordinfoService.insert(doctorVisitRecordinfo);
        }
        return "forward:listall.action";
    }

    @RequestMapping("/delete") 
    public String delete(Integer vrId, HttpServletResponse response) throws IOException { 
        doctorVisitRecordService.delete(vrId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.update(doctorVisitRecord); 
        return "forward:listall.action";
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.updateSelective(doctorVisitRecord); 
        return "forward:listall.action";
    } 
 
    @RequestMapping("/load") 
    public String load(Integer vrId, Model model) { 
        DoctorVisitRecord doctorVisitRecord = doctorVisitRecordService.findById(vrId); 
        model.addAttribute("doctorVisitRecord",doctorVisitRecord); 
        return "doctorVisitRecord/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model, HttpSession session) throws IOException {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        List<PatientRegisterRecord> list = patientRegisterRecordService.findZAll(sessionUser.getUserId());
        model.addAttribute("list",list); 
        return "doctorVisitRecord/list"; 
    }

    @RequestMapping("/listall")
    public String list(Model model) throws IOException {
        List<DoctorVisitRecord> list = doctorVisitRecordService.findAll();
        model.addAttribute("list",list);
        return "doctorVisitRecord/listall";
    }
    //测试用
    @RequestMapping("/ajaxListss")
    public void ajaxListss(HttpServletResponse response,HttpSession session) throws IOException {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        List<PatientRegisterRecord> list = patientRegisterRecordService.findZAll(sessionUser.getUserId());
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<PatientRegisterRecord> list = doctorVisitRecordService.findAll();
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(DoctorVisitRecord doctorVisitRecord,Model model) { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.search(doctorVisitRecord); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",doctorVisitRecord); 
        return "doctorVisitRecord/listall";
    } 
 
} 
