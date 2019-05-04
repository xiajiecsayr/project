package com.qhit.test.controller; 

import com.qhit.test.pojo.Test; 
import com.qhit.test.service.ITestService; 
import com.qhit.test.service.impl.TestServiceImpl; 
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
* Created by GeneratorCode on 2018/12/24
*/ 

@Controller 
@RequestMapping("/test") 
public class TestController { 

    @Resource 
    ITestService testService; 

    @RequestMapping("/insert") 
    public String insert(Test test) { 
        testService.insert(test); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer tId, HttpServletResponse response) throws IOException {
        testService.delete(tId);
        return "forward:list.action"; 
    }
    @RequestMapping("/deleteBatch")
    public String deleteBatch(HttpServletRequest request) throws IOException {
        String[] tIds = request.getParameterValues("tId");
        testService.deleteBatch(tIds);
        return "forward:list.action";
    }

    @RequestMapping("/update") 
    public String update(Test test) { 
        testService.update(test); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Test test) { 
        testService.updateSelective(test); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer tId, Model model) { 
        Test test = testService.findById(tId); 
        model.addAttribute("test",test); 
        return "test/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Test> list = testService.findAll(); 
        model.addAttribute("list",list); 
        return "test/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Test> list = testService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Test test,Model model) { 
        List<Test> list = testService.search(test); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",test); 
        return "test/list"; 
    } 
 
} 
