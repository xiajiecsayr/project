package com.qhit.medicinePurchaseInfo.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService; 
import com.qhit.medicinePurchaseInfo.service.impl.MedicinePurchaseInfoServiceImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineReqPlan.service.IMedicineReqPlanService;
import com.qhit.medicineReqPlan.service.impl.MedicineReqPlanServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/06
*/
@Controller 
@RequestMapping("/medicinePurchaseInfo") 
public class MedicinePurchaseInfoController { 

    IMedicinePurchaseInfoService medicinePurchaseInfoService = new MedicinePurchaseInfoServiceImpl();
    IMedicineReqPlanService medicineReqPlanService = new MedicineReqPlanServiceImpl();

    @RequestMapping("/insert") 
    public String insert(MedicinePurchaseInfo medicinePurchaseInfo,HttpSession session) {
        boolean flag = CommonUtil.isRoleExists(session,16);
        String url = "";
        if(flag){
            medicinePurchaseInfo.setStatus(2);
            url="forward:apprvlist.action";
        }else {
            medicinePurchaseInfo.setStatus(1);
            url="forward:list.action";
        }
        medicinePurchaseInfoService.insert(medicinePurchaseInfo);
        return url;
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer pchId, HttpServletResponse response) throws IOException { 
        medicinePurchaseInfoService.delete(pchId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.update(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load")
    public String load(Integer pchId, Model model,HttpServletRequest request) {
        boolean flags = (boolean) request.getAttribute("flags");
        if(!flags){
            return "sorry/sorry";
        }
        MedicinePurchaseInfo medicinePurchaseInfo = medicinePurchaseInfoService.findById(pchId); 
        model.addAttribute("medicinePurchaseInfo",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findSAll();
        MedicinePurchaseInfo medicinePurchaseInfo = new MedicinePurchaseInfo();
        MedicinePurchaseInfo medicinePurchaseInfo1 =medicinePurchaseInfoService.findByusernme(medicinePurchaseInfo.getPchUserid());
        model.addAttribute("uame",medicinePurchaseInfo1);
        model.addAttribute("list",list);
        return "medicinePurchaseInfo/list"; 
    }
    @RequestMapping("/apprvlist")
    public String apprvlist(Model model) throws IOException {
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findSAll();
        MedicinePurchaseInfo medicinePurchaseInfo = new MedicinePurchaseInfo();
        MedicinePurchaseInfo medicinePurchaseInfo1 =medicinePurchaseInfoService.findByusernme(medicinePurchaseInfo.getPchUserid());
        model.addAttribute("list",list);
        model.addAttribute("uame",medicinePurchaseInfo1);
        return "medicinePurchaseInfo/apprvlist";
    }
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response,HttpSession session) throws IOException {
//        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findAll();
        List<MedicineReqPlan> list = medicinePurchaseInfoService.collects();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicinePurchaseInfo medicinePurchaseInfo,Model model) { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.search(medicinePurchaseInfo); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/list"; 
    }
    @RequestMapping("/collect")
    public String collect(HttpSession session) {
        medicinePurchaseInfoService.collect(session);
        return "forward:list.action";
    }

    @RequestMapping("/updateBantch")
    public String updateBantch(HttpServletRequest request) {
        String[] pchIds = request.getParameterValues("pchId");
        String[] inputids = request.getParameterValues("inputid");
        for (String inpid:inputids) {
            MedicinePurchaseInfo medicinePurchaseInfo = medicinePurchaseInfoService.findById(inpid);
            for (String pchId : pchIds) {
                //根据id查询计划表里的数据
                MedicineReqPlan reqPlan = medicineReqPlanService.findById(pchId);
                //更改计划表里的状态
                reqPlan.setStatus(4);
                medicineReqPlanService.updateSelective(reqPlan);
                medicinePurchaseInfo.setStatus(1);
                medicinePurchaseInfoService.updateSelectives(medicinePurchaseInfo);
               /* //如果审批采购后计划表状态为已采购且采购表状态变为采购已审批时更改采购表药品数量和状态
                MedicinePurchaseInfo medicinePurchaseInfo1 = medicinePurchaseInfoService.findBySta(medicinePurchaseInfo,reqPlan);
                if(medicinePurchaseInfo1!=null){
                    medicinePurchaseInfo1.setPchAmt(medicinePurchaseInfo.getPchAmt()+reqPlan.getReqamt());
                    medicinePurchaseInfo1.setStatus(1);
                    medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo1);
                }*/
            }
        }
        return "forward:apprvlist.action";
    }

 
} 
