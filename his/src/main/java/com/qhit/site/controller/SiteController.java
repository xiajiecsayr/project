package com.qhit.site.controller; 

import com.qhit.site.pojo.Site; 
import com.qhit.site.service.ISiteService; 
import com.qhit.site.service.impl.SiteServiceImpl; 
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
@RequestMapping("/site") 
public class SiteController { 

    @Resource 
    ISiteService siteService; 

    @RequestMapping("/insert") 
    public String insert(Site site) { 
        siteService.insert(site); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer mId, HttpServletResponse response) throws IOException { 
        siteService.delete(mId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Site site) { 
        siteService.update(site); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Site site) { 
        siteService.updateSelective(site); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer mId, Model model) { 
        Site site = siteService.findById(mId); 
        model.addAttribute("site",site); 
        return "site/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Site> list = siteService.findAll(); 
        model.addAttribute("list",list); 
        return "site/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Site> list = siteService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Site site,Model model) { 
        List<Site> list = siteService.search(site); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",site); 
        return "site/list"; 
    } 
 
} 
