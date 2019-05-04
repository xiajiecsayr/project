package com.qhit.study.controller; 

import com.qhit.study.pojo.Study; 
import com.qhit.study.service.IStudyService; 
import com.qhit.study.service.impl.StudyServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/** 
* Created by GeneratorCode on 2018/12/26
*/ 

@Controller 
@RequestMapping("/study") 
public class StudyController { 

    @Resource 
    IStudyService studyService; 

    @RequestMapping("/insert") 
    public String insert(Study study) { 
        studyService.insert(study); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer sId, HttpServletResponse response) throws IOException { 
        studyService.delete(sId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Study study) { 
        studyService.update(study); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Study study) { 
        studyService.updateSelective(study); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer sId, Model model) { 
        Study study = studyService.findById(sId); 
        model.addAttribute("study",study); 
        return "study/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Study> list = studyService.findAll(); 
        model.addAttribute("list",list); 
        return "study/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Study> list = studyService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Study study,Model model) { 
        List<Study> list = studyService.search(study); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",study); 
        return "study/list"; 
    } 
 
} 
