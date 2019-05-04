package com.qhit.medicineInstock.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.medicineInstock.pojo.MedicineInstock;
import com.qhit.medicineInstock.service.IMedicineInstockService; 
import com.qhit.medicineInstock.service.impl.MedicineInstockServiceImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService;
import com.qhit.medicinePurchaseInfo.service.impl.MedicinePurchaseInfoServiceImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineReqPlan.service.IMedicineReqPlanService;
import com.qhit.medicineReqPlan.service.impl.MedicineReqPlanServiceImpl;
import com.qhit.medicineStockinfo.pojo.MedicineStockinfo;
import com.qhit.medicineStockinfo.service.IMedicineStockinfoService;
import com.qhit.medicineStockinfo.service.impl.MedicineStockinfoServiceImpl;
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
* Created by GeneratorCode on 2018/12/12
*/
@Controller 
@RequestMapping("/medicineInstock") 
public class MedicineInstockController  {

        IMedicineInstockService medicineInstockService = new MedicineInstockServiceImpl();
        IMedicinePurchaseInfoService medicinePurchaseInfoService = new MedicinePurchaseInfoServiceImpl();
        IMedicineStockinfoService medicineStockinfoService = new MedicineStockinfoServiceImpl();
        IMedicineReqPlanService medicineReqPlanService = new MedicineReqPlanServiceImpl();
        @RequestMapping("/insert")
        public String insert (MedicineInstock medicineInstock){
        medicineInstockService.insert(medicineInstock);
        return "forward:list.action";
    }

        @RequestMapping("/delete")
        public String delete (Integer instockId, HttpServletResponse response) throws IOException {
        medicineInstockService.delete(instockId);
        return "forward:list.action";
    }

        @RequestMapping("/update")
        public String update (MedicineInstock medicineInstock){
        medicineInstockService.update(medicineInstock);
        return "forward:list.action";
    }

        @RequestMapping("/updateSelective")
        public String updateSelective (MedicineInstock medicineInstock){
        medicineInstockService.updateSelective(medicineInstock);
        return "forward:list.action";
    }

        @RequestMapping("/load")
        public String load (Integer instockId, Model model){
        MedicineInstock medicineInstock = medicineInstockService.findById(instockId);
        model.addAttribute("medicineInstock", medicineInstock);
        return "medicineInstock/edit";
    }

        @RequestMapping("/list")
        public String list (Model model) throws IOException {
        List<MedicineInstock> list = medicineInstockService.findSAll();
        model.addAttribute("list", list);
        return "medicineInstock/list";
    }

        @RequestMapping("/ajaxList")
        public void ajaxList (HttpServletResponse response) throws IOException {
        List<MedicineInstock> list = medicineInstockService.findAll();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }

        @RequestMapping("/search")
        public String search (MedicineInstock medicineInstock, Model model){
        List<MedicineInstock> list = medicineInstockService.search(medicineInstock);
        model.addAttribute("list", list);
        model.addAttribute("searchObject", medicineInstock);
        return "medicineInstock/list";
    }
        @RequestMapping("/updateBantch")
        public String updateBantch (HttpServletRequest request, HttpSession session){
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        String[] pchIds = request.getParameterValues("pchId");
        String[] invnos = request.getParameterValues("invno");
        MedicineInstock medicineInstock = new MedicineInstock();
        for (String pchId : pchIds) {//pchId 代表id
            //根据传过来的采购信息表的id查询所有信息
            MedicinePurchaseInfo medicinePurchaseInfo1 = medicinePurchaseInfoService.findById(pchId);
            medicineInstock.setInstockId(Integer.parseInt(pchId));
            for (String invno : invnos) {
                medicineInstock.setInvno(invno);
            }
            medicineInstock.setMedicineCodeid(medicinePurchaseInfo1.getMedicineCodeid());
            medicineInstock.setInamt(medicinePurchaseInfo1.getPchAmt());
            medicineInstock.setUnitprc(medicinePurchaseInfo1.getPchPrice());
            medicineInstock.setZje(medicinePurchaseInfo1.getPchTotal());
            medicineInstock.setInstockUserid(sessionUser.getUserId());
            medicineInstock.setInstockDate(CommonUtil.dateToStr(new Date()));
            medicineInstock.setManCode(medicinePurchaseInfo1.getManCode());
            medicinePurchaseInfo1.setStatus(3);
            medicineInstockService.insert(medicineInstock);
            medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo1);
            //入库表
            //查询是否有这个药名
            MedicineStockinfo medicineStockinfo = medicineInstockService.ifID(medicinePurchaseInfo1);
            if (medicineStockinfo != null) {
                medicineStockinfo.setAmt(medicineStockinfo.getAmt() + medicinePurchaseInfo1.getPchAmt());
                medicineStockinfoService.updateSelective(medicineStockinfo);
                medicineStockinfo.setZje(medicinePurchaseInfo1.getPchTotal() + medicineStockinfo.getZje());
                medicineStockinfoService.updateSelective(medicineStockinfo);
                medicineStockinfo.setUnitprc((medicinePurchaseInfo1.getPchTotal() + medicineStockinfo.getZje()) / (medicineStockinfo.getAmt() + medicinePurchaseInfo1.getPchAmt()));
                medicineStockinfoService.updateSelective(medicineStockinfo);
                medicineStockinfo.setSaleunitprc(((medicinePurchaseInfo1.getPchTotal() + medicineStockinfo.getZje()) / (medicineStockinfo.getAmt() + medicinePurchaseInfo1.getPchAmt())) * 1.5);
                medicineStockinfoService.updateSelective(medicineStockinfo);
                /*//更改计划表状态5（入库）
                MedicineReqPlan medicineReqPlan = medicineReqPlanService.findById(medicinePurchaseInfo1.getMedicineCodeid());
                medicineReqPlan.setStatus(5);
                medicineReqPlanService.updateSelective(medicineReqPlan);*/

            } else {
                MedicineStockinfo medicineStockinfo1 = new MedicineStockinfo();
                medicineStockinfo1.setMedicinecodeId(medicinePurchaseInfo1.getMedicineCodeid());
                medicineStockinfo1.setAmt(medicinePurchaseInfo1.getPchAmt());
                medicineStockinfo1.setUnitprc(medicinePurchaseInfo1.getPchPrice());
                medicineStockinfo1.setSaleunitprc(medicinePurchaseInfo1.getPchPrice() * 1.5);
                medicineStockinfo1.setZje(medicinePurchaseInfo1.getPchTotal());
                medicineStockinfoService.insert(medicineStockinfo1);
                /*//更改计划表状态5（入库）
                MedicineReqPlan medicineReqPlan = medicineReqPlanService.findById(medicinePurchaseInfo1.getMedicineCodeid());
                medicineReqPlan.setStatus(5);
                medicineReqPlanService.updateSelective(medicineReqPlan);*/
            }
        }
        return "forward:list.action";
    }
        @RequestMapping("/apprvlist")
        public String apprvlist (Model model) throws IOException {
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findSSAll();
        MedicinePurchaseInfo medicinePurchaseInfo = new MedicinePurchaseInfo();
        MedicinePurchaseInfo medicinePurchaseInfo1 = medicinePurchaseInfoService.findByusernme(medicinePurchaseInfo.getPchUserid());
        model.addAttribute("list", list);
        model.addAttribute("uame", medicinePurchaseInfo1);
        return "medicineInstock/apprvlist";

    }

} 
