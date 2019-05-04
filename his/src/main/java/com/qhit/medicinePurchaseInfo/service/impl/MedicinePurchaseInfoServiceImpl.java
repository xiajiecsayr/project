package com.qhit.medicinePurchaseInfo.service.impl;

import com.qhit.baseManufacturer.pojo.BaseManufacturer;
import com.qhit.common.CommonUtil;
import com.qhit.medicineCode.pojo.MedicineCode;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService;

import java.util.Date;
import java.util.List;
import com.qhit.medicinePurchaseInfo.dao.IMedicinePurchaseInfoDao;
import com.qhit.medicinePurchaseInfo.dao.impl.MedicinePurchaseInfoDaoImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineReqPlan.service.IMedicineReqPlanService;
import com.qhit.medicineReqPlan.service.impl.MedicineReqPlanServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* Created by GeneratorCode on 2018/12/06
*/

public class MedicinePurchaseInfoServiceImpl  implements IMedicinePurchaseInfoService {

    IMedicinePurchaseInfoDao dao = new MedicinePurchaseInfoDaoImpl();
    IMedicineReqPlanService medicineReqPlanService = new MedicineReqPlanServiceImpl();
    @Override
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(MedicinePurchaseInfo medicinePurchaseInfo) {
        //计算总价
        if(medicinePurchaseInfo.getPchAmt()!=null && medicinePurchaseInfo.getPchPrice()!=null){
        medicinePurchaseInfo.setPchTotal(medicinePurchaseInfo.getPchAmt()*medicinePurchaseInfo.getPchPrice());
        }
        return dao.updateSelective(medicinePurchaseInfo);
    }

    @Override
    public boolean updateSelectives(Object object) {
        return dao.updateSelective(object);
    }


    @Override 
    public boolean delete(Object id) { 
        MedicinePurchaseInfo medicinePurchaseInfo = findById(id); 
        return dao.delete(medicinePurchaseInfo); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public MedicinePurchaseInfo findById(Object id) { 
        List<MedicinePurchaseInfo> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicinePurchaseInfo> search(MedicinePurchaseInfo medicinePurchaseInfo) {
            String sql = "select * from medicine_purchase_info where 1=1 "; 
            if (medicinePurchaseInfo.getMedicineCodeid()!=null && !"".equals(medicinePurchaseInfo.getMedicineCodeid())){        
                sql+=" and MEDICINE_CODEID like '%"+medicinePurchaseInfo.getMedicineCodeid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getManCode()!=null && !"".equals(medicinePurchaseInfo.getManCode())){        
                sql+=" and MAN_CODE like '%"+medicinePurchaseInfo.getManCode()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchAmt()!=null && !"".equals(medicinePurchaseInfo.getPchAmt())){        
                sql+=" and PCH_AMT like '%"+medicinePurchaseInfo.getPchAmt()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchPrice()!=null && !"".equals(medicinePurchaseInfo.getPchPrice())){        
                sql+=" and PCH_PRICE like '%"+medicinePurchaseInfo.getPchPrice()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchTotal()!=null && !"".equals(medicinePurchaseInfo.getPchTotal())){        
                sql+=" and PCH_TOTAL like '%"+medicinePurchaseInfo.getPchTotal()+"%' ";        
            } 
            if (medicinePurchaseInfo.getStatus()!=null && !"".equals(medicinePurchaseInfo.getStatus())){        
                sql+=" and STATUS like '%"+medicinePurchaseInfo.getStatus()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchUserid()!=null && !"".equals(medicinePurchaseInfo.getPchUserid())){        
                sql+=" and PCH_USERID like '%"+medicinePurchaseInfo.getPchUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchDate()!=null && !"".equals(medicinePurchaseInfo.getPchDate())){        
                sql+=" and PCH_DATE like '%"+medicinePurchaseInfo.getPchDate()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvUserid()!=null && !"".equals(medicinePurchaseInfo.getApprvUserid())){        
                sql+=" and APPRV_USERID like '%"+medicinePurchaseInfo.getApprvUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvDate()!=null && !"".equals(medicinePurchaseInfo.getApprvDate())){        
                sql+=" and APPRV_DATE like '%"+medicinePurchaseInfo.getApprvDate()+"%' ";        
            } 
            List<MedicinePurchaseInfo> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public void collect(HttpSession session) {
        //        更新需求计划表，改为状态为3
        String sql1 ="UPDATE medicine_req_plan SET STATUS=3 WHERE STATUS=2";
        String sql2 ="SELECT medicine_codeid,cast(SUM(reqamt) as char) as sumamt \n" +
                "from medicine_req_plan WHERE STATUS=2 GROUP BY medicine_codeid";
        List<MedicineReqPlan> list = dao.freeFind(sql2);
        //        往采购信息表中插入数据
            for(MedicineReqPlan medicineReqPlan:list){
                //查找采购表里是否已存在添加的药品id
                String sql4 = "SELECT * from medicine_purchase_info mpi JOIN medicine_req_plan mrp ON mpi.MEDICINE_CODEID=mrp.MEDICINE_CODEID\n" +
                        "\t\t\t\t\tWHERE mpi.MEDICINE_CODEID='"+medicineReqPlan.getMedicineCodeid()+"' GROUP BY mpi.MEDICINE_CODEID";
                List<MedicinePurchaseInfo> list2 = dao.freeFind(sql4);
                if(list2!=null){
                      MedicinePurchaseInfo medicinePurchaseInfo = this.findByCodeid(medicineReqPlan);
                      for(MedicinePurchaseInfo mpi:list2){
                          MedicineReqPlan medicineReqPlan1 = medicineReqPlanService.findBymrp(mpi.getMedicineCodeid());
                          if(medicineReqPlan1!=null) {
                              //更改采购表数量
                              medicinePurchaseInfo.setPchAmt(medicinePurchaseInfo.getPchAmt() + medicineReqPlan1.getReqamt());
                          }else {
                              MedicinePurchaseInfo purchaseInfo = new MedicinePurchaseInfo();
                              String sql3 = "SELECT * from medicine_req_plan mrp JOIN medicine_code mc ON mrp.MEDICINE_CODEID=mc.code_id\n" +
                                      "\t\t\t\t    JOIN base_manufacturer bm ON bm.man_Code=mc.man_code";
                              List<MedicineReqPlan> list1 = dao.freeFind(sql3);
                              for(MedicineReqPlan medicineReqPlan2:list1){
                                  purchaseInfo.setManCode(medicineReqPlan2.getBaseManufacturer().getManCode());
                              }
                /*String sql3 = "SELECT * FROM medicine_purchase_info WHERE MEDICINE_CODEID ='"+medicineReqPlan.getMedicineCodeid()+"'";
                List<MedicinePurchaseInfo> list1 = dao.freeFind(sql3);*/
                              purchaseInfo.setMedicineCodeid(medicineReqPlan.getMedicineCodeid());
                              purchaseInfo.setPchAmt(Integer.parseInt(medicineReqPlan.getSumamt()));
                              purchaseInfo.setStatus(2);
                              purchaseInfo.setPchDate(CommonUtil.dateToStr(new Date()));
                              purchaseInfo.setPchUserid(CommonUtil.getUserId(session));
                              dao.insert(purchaseInfo);
                          }
                          this.updateSelective(medicinePurchaseInfo);
                      }
                }else {
                    MedicinePurchaseInfo purchaseInfo = new MedicinePurchaseInfo();
                    String sql3 = "SELECT * from medicine_req_plan mrp JOIN medicine_code mc ON mrp.MEDICINE_CODEID=mc.code_id\n" +
                            "\t\t\t\t    JOIN base_manufacturer bm ON bm.man_Code=mc.man_code";
                    List<MedicineReqPlan> list1 = dao.freeFind(sql3);
                    for(MedicineReqPlan medicineReqPlan1:list1){
                        purchaseInfo.setManCode(medicineReqPlan1.getBaseManufacturer().getManCode());
                    }
                /*String sql3 = "SELECT * FROM medicine_purchase_info WHERE MEDICINE_CODEID ='"+medicineReqPlan.getMedicineCodeid()+"'";
                List<MedicinePurchaseInfo> list1 = dao.freeFind(sql3);*/
                    purchaseInfo.setMedicineCodeid(medicineReqPlan.getMedicineCodeid());
                    purchaseInfo.setPchAmt(Integer.parseInt(medicineReqPlan.getSumamt()));
                    purchaseInfo.setStatus(2);
                    purchaseInfo.setPchDate(CommonUtil.dateToStr(new Date()));
                    purchaseInfo.setPchUserid(CommonUtil.getUserId(session));
                    dao.insert(purchaseInfo);
                }
                dao.freeUpdate(sql1);
            }

            }



    @Override
    public List<MedicinePurchaseInfo> findSAll() {
        String sql = "SELECT * from medicine_purchase_info mpi JOIN medicine_code mc \n" +
                "\t\t\t\t\t ON mpi.MEDICINE_CODEID=mc.code_id\n" +
                "\t\t\t\t\t JOIN medicine_req_plan mrp \n" +
                "\t\t\t\t\t ON mc.code_id=mrp.MEDICINE_CODEID \n" +
                "\t\t\t\t\t JOIN base_user bu\n" +
                "\t\t\t\t\t ON mrp.APPRV_USERID = bu.user_id " +
                "GROUP BY mc.code_id,mpi.STATUS";
        return dao.freeFind(sql);
    }

    @Override
    public List<MedicineReqPlan> collects() {
       String sql = "SELECT * from medicine_req_plan WHERE STATUS = 2";
       return dao.freeFind(sql);
    }

    @Override
    public MedicinePurchaseInfo findByusernme(Integer pchUserid) {
        String sql = "SELECT * from medicine_purchase_info mpi " +
                     "JOIN base_user bu ON bu.user_id=mpi.PCH_USERID";
        List<MedicinePurchaseInfo> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<MedicinePurchaseInfo> findSSAll() {
        String sql = "SELECT * from medicine_purchase_info mpi JOIN medicine_code mc \n" +
                "\t\t\t\t\t ON mpi.MEDICINE_CODEID=mc.code_id\n" +
                "\t\t\t\t\t JOIN medicine_req_plan mrp \n" +
                "\t\t\t\t\t ON mc.code_id=mrp.MEDICINE_CODEID \n" +
                "\t\t\t\t\t JOIN base_user bu\n" +
                "\t\t\t\t\t ON mrp.APPRV_USERID = bu.user_id " +
                "\t\t\t\t\t WHERE mpi.STATUS=1 " +
                "GROUP BY mc.code_id";
        return dao.freeFind(sql);
    }

    @Override
    public MedicinePurchaseInfo findByCodeid(MedicineReqPlan medicineReqPlan) {
        String sql = "SELECT * from medicine_purchase_info WHERE MEDICINE_CODEID = '"+medicineReqPlan.getMedicineCodeid()+"'";
        List<MedicinePurchaseInfo> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public MedicinePurchaseInfo findBySta(MedicinePurchaseInfo medicinePurchaseInfo, MedicineReqPlan reqPlan) {
        String sql = "SELECT * from medicine_purchase_info mpi JOIN medicine_req_plan mrp \n" +
                "\t\t\t\t\t ON mpi.MEDICINE_CODEID = mrp.MEDICINE_CODEID\n" +
                "\t\t\t\t\t WHERE mrp.STATUS=4\n" +
                "\t\t\t\t\t AND mpi.STATUS=1";
        List<MedicinePurchaseInfo> list = dao.freeFind(sql);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }


}