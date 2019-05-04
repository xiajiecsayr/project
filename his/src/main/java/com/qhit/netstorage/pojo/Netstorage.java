package com.qhit.netstorage.pojo;


import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.users.pojo.Users;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/12/20
*/

public class Netstorage {

    private Integer fileid;    //
    private String filename;    //
    private Integer filesize;    //
    private String uploaddate;    //
    private Integer uid;    //

    @Description("bean")
    private BaseUser baseUser;

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public Integer getFileid() {
        return fileid;
    }
 
    public void setFileid(Integer fileid) { 
        this.fileid = fileid;
    }
 
    public String getFilename() { 
        return filename;
    }
 
    public void setFilename(String filename) { 
        this.filename = filename;
    }
 
    public Integer getFilesize() { 
        return filesize;
    }
 
    public void setFilesize(Integer filesize) { 
        this.filesize = filesize;
    }
 
    public String getUploaddate() { 
        return uploaddate;
    }
 
    public void setUploaddate(String uploaddate) { 
        this.uploaddate = uploaddate;
    }
 
    public Integer getUid() { 
        return uid;
    }
 
    public void setUid(Integer uid) { 
        this.uid = uid;
    }
 

 }