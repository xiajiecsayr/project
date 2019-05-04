package com.qhit.medicineReqPlan.pojo;


import com.qhit.baseManufacturer.pojo.BaseManufacturer;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.medicineCode.pojo.MedicineCode;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/12/06
*/

public class MedicineReqPlan {

    private Integer reqplnno;    //需求计划编号
    private Integer medicineCodeid;    //药品
    private Integer reqamt;    //需求数量
    private Integer appUserid;    //申请人
    private String appDate;    //申请日期
    private String purpose;    //用途
    private Integer status;    //状态
    private Integer apprvUserid;    //审批人
    private String apprvDate;    //审批日期

    @Description("bean")
    private MedicinePurchaseInfo medicinePurchaseInfo;

    @Description("un")
    private String sumamt;

    @Description("un")
    private String medicineName;//药品名称

    @Description("bean")
    private MedicineCode medicineCode;
    @Description("bean")
    private BaseUser baseUser;
    @Description("bean")
    private BaseManufacturer baseManufacturer;

    @Description("un")
    private String sumreqamt;

    public MedicinePurchaseInfo getMedicinePurchaseInfo() {
        return medicinePurchaseInfo;
    }

    public void setMedicinePurchaseInfo(MedicinePurchaseInfo medicinePurchaseInfo) {
        this.medicinePurchaseInfo = medicinePurchaseInfo;
    }

    public BaseManufacturer getBaseManufacturer() {
        return baseManufacturer;
    }

    public void setBaseManufacturer(BaseManufacturer baseManufacturer) {
        this.baseManufacturer = baseManufacturer;
    }

    public String getSumreqamt() {
        return sumreqamt;
    }

    public void setSumreqamt(String sumreqamt) {
        this.sumreqamt = sumreqamt;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getSumamt() {
        return sumamt;
    }

    public void setSumamt(String sumamt) {
        this.sumamt = sumamt;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public MedicineCode getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(MedicineCode medicineCode) {
        this.medicineCode = medicineCode;
    }

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public Integer getReqplnno() {
        return reqplnno;
    }
 
    public void setReqplnno(Integer reqplnno) { 
        this.reqplnno = reqplnno;
    }
 
    public Integer getMedicineCodeid() { 
        return medicineCodeid;
    }
 
    public void setMedicineCodeid(Integer medicineCodeid) { 
        this.medicineCodeid = medicineCodeid;
    }
 
    public Integer getReqamt() { 
        return reqamt;
    }
 
    public void setReqamt(Integer reqamt) { 
        this.reqamt = reqamt;
    }
 
    public Integer getAppUserid() { 
        return appUserid;
    }
 
    public void setAppUserid(Integer appUserid) { 
        this.appUserid = appUserid;
    }
 
    public String getAppDate() { 
        return appDate;
    }
 
    public void setAppDate(String appDate) { 
        this.appDate = appDate;
    }
 
    public String getPurpose() { 
        return purpose;
    }
 
    public void setPurpose(String purpose) { 
        this.purpose = purpose;
    }
 
    public Integer getStatus() { 
        return status;
    }
 
    public void setStatus(Integer status) { 
        this.status = status;
    }
 
    public Integer getApprvUserid() { 
        return apprvUserid;
    }
 
    public void setApprvUserid(Integer apprvUserid) { 
        this.apprvUserid = apprvUserid;
    }
 
    public String getApprvDate() { 
        return apprvDate;
    }
 
    public void setApprvDate(String apprvDate) { 
        this.apprvDate = apprvDate;
    }
 

 }