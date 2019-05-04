package com.qhit.test1.controller; 

import com.qhit.test1.pojo.Test1; 
import com.qhit.test1.service.ITest1Service; 
import com.qhit.test1.service.impl.Test1ServiceImpl; 
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
* Created by GeneratorCode on 2018/12/25
*/ 

@Controller 
@RequestMapping("/test1") 
public class Test1Controller { 

    @Resource 
    ITest1Service test1Service; 

    @RequestMapping("/insert") 
    public String insert(Test1 test1) { 
        test1Service.insert(test1); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer aId, HttpServletResponse response) throws IOException { 
        test1Service.delete(aId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Test1 test1) { 
        test1Service.update(test1); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Test1 test1) { 
        test1Service.updateSelective(test1); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer aId, Model model) { 
        Test1 test1 = test1Service.findById(aId); 
        model.addAttribute("test1",test1); 
        return "test1/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Test1> list = test1Service.findAll(); 
        model.addAttribute("list",list); 
        return "test1/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Test1> list = test1Service.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Test1 test1,Model model) { 
        List<Test1> list = test1Service.search(test1); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",test1); 
        return "test1/list"; 
    } 
 
} 
