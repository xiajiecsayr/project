package com.qhit.baseFlow.pojo;


import com.qhit.baseCompany.pojo.BaseCompany;
import com.qhit.baseDevice.pojo.BaseDevice;

import java.util.List;

/**
* Created by GeneratorCode on 2019/04/09
*/ 

public class BaseFlow { 
    private Integer flowid;    //主键 
    private String flowname;    //流程名称 
    private Integer dljid;    //斗轮机 
    private Integer zcjid;    //装船机 
    private Integer pdjid;    //皮带机 
    private Integer compid;    //所属企业
    private String compname;   //企业名称
    private String dljname;  //斗轮机名字
    private String zcjname;  //装船机名字
    private String pdjname;  //皮带机名字
    private List<BaseDevice> devlist;
    private String tol;
    private String dljdevid;
    private String dljamount;
    private String zcjdevid;
    private String zcjamount;
    private String pdjdevid;
    private String pdjamount;

    public Integer getFlowid() { 
        return flowid;
    }

    public void setFlowid(Integer flowid) { 
        this.flowid = flowid;
    } 

    public String getFlowname() { 
        return flowname;
    }

    public void setFlowname(String flowname) { 
        this.flowname = flowname;
    }
    public Integer getDljid() { 
        return dljid;
    }

    public void setDljid(Integer dljid) { 
        this.dljid = dljid;
    } 

    public Integer getZcjid() { 
        return zcjid;
    }

    public void setZcjid(Integer zcjid) { 
        this.zcjid = zcjid;
    } 

    public Integer getPdjid() { 
        return pdjid;
    }

    public void setPdjid(Integer pdjid) { 
        this.pdjid = pdjid;
    } 

    public Integer getCompid() { 
        return compid;
    }

    public void setCompid(Integer compid) { 
        this.compid = compid;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getDljname() {
        return dljname;
    }

    public void setDljname(String dljname) {
        this.dljname = dljname;
    }

    public String getZcjname() {
        return zcjname;
    }

    public void setZcjname(String zcjname) {
        this.zcjname = zcjname;
    }

    public String getPdjname() {
        return pdjname;
    }

    public void setPdjname(String pdjname) {
        this.pdjname = pdjname;
    }

    public List<BaseDevice> getDevlist() {
        return devlist;
    }

    public void setDevlist(List<BaseDevice> devlist) {
        this.devlist = devlist;
    }

    public String getTol() {
        return tol;
    }

    public void setTol(String tol) {
        this.tol = tol;
    }

    public String getDljdevid() {
        return dljdevid;
    }

    public void setDljdevid(String dljdevid) {
        this.dljdevid = dljdevid;
    }

    public String getDljamount() {
        return dljamount;
    }

    public void setDljamount(String dljamount) {
        this.dljamount = dljamount;
    }

    public String getZcjdevid() {
        return zcjdevid;
    }

    public void setZcjdevid(String zcjdevid) {
        this.zcjdevid = zcjdevid;
    }

    public String getZcjamount() {
        return zcjamount;
    }

    public void setZcjamount(String zcjamount) {
        this.zcjamount = zcjamount;
    }

    public String getPdjdevid() {
        return pdjdevid;
    }

    public void setPdjdevid(String pdjdevid) {
        this.pdjdevid = pdjdevid;
    }

    public String getPdjamount() {
        return pdjamount;
    }

    public void setPdjamount(String pdjamount) {
        this.pdjamount = pdjamount;
    }
}