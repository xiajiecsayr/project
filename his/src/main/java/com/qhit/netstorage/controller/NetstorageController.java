package com.qhit.netstorage.controller; 

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.CommonUtil;
import com.qhit.netstorage.pojo.Netstorage;
import com.qhit.netstorage.service.INetstorageService; 
import com.qhit.netstorage.service.impl.NetstorageServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/20
*/
@Controller 
@RequestMapping("/netstorage") 
public class NetstorageController { 

    INetstorageService netstorageService = new NetstorageServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(Netstorage netstorage) {
        netstorageService.insert(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer fileid, HttpServletResponse response) throws IOException { 
        netstorageService.delete(fileid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Netstorage netstorage) { 
        netstorageService.update(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Netstorage netstorage) { 
        netstorageService.updateSelective(netstorage); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer fileid, Model model) { 
        Netstorage netstorage = netstorageService.findById(fileid); 
        model.addAttribute("netstorage",netstorage); 
        return "netstorage/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Netstorage> list = netstorageService.findSAll();
        model.addAttribute("list",list); 
        return "netstorage/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Netstorage> list = netstorageService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Netstorage netstorage,Model model) { 
        List<Netstorage> list = netstorageService.search(netstorage); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",netstorage); 
        return "netstorage/list"; 
    }
    @RequestMapping("/addscommodity")
    public String addscommodity(Netstorage netstorage, HttpSession session,HttpServletRequest request) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        String wenjain = request.getParameter("wenjian");
        String[] wenjains = wenjain.split(",");
        String upload = request.getSession().getServletContext().getRealPath("upload");
        for (String wen:wenjains){
            File file = new File(upload+"/"+wen);
            netstorage.setFilesize((int) file.length());//文件大小
            netstorage.setFilename(wen);//文件名
            netstorage.setUploaddate(CommonUtil.dateToStr(new Date()));//上传日期
            netstorage.setUid(sessionUser.getUserId());//上传用户
            netstorageService.insert(netstorage);
        }
        return "forward:list.action";
    }
 
} 
