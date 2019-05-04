package com.qhit.baseFunction.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseFunction.service.IBaseFunctionService;
import com.qhit.baseFunction.service.impl.BaseFunctionServiceImpl;
import com.qhit.baseModule.pojo.BaseModule;
import com.qhit.baseModule.service.IBaseModuleService;
import com.qhit.baseModule.service.impl.BaseModuleServiceImpl;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by yy on 2018/11/28.
 */
@Controller
@RequestMapping("/baseFunction")
public class BaseFunctions {

    private IBaseFunctionService iBaseFunctionService = new BaseFunctionServiceImpl();
    private IBaseModuleService iBaseModuleService = new BaseModuleServiceImpl();
    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        List<BaseFunctions> list = iBaseFunctionService.findAlls();
        request.setAttribute("list",list);
        return "baseFunction/list";
    }
    @RequestMapping("/adds")
    public String adds(HttpServletRequest request){
        List<BaseModule> list = iBaseModuleService.findAll();
        request.setAttribute("list",list);
        return "baseFunction/add";
    }
    @RequestMapping("/insert")
    public String insert(BaseModule baseModule, BaseFunction baseFunction){
        baseModule = iBaseModuleService.findBymname(baseModule.getMname());
        if(baseFunction.getMid()!=null){
            baseFunction.setMid(baseModule.getMid());
        }
        iBaseFunctionService.insert(baseFunction);
        return "redirect:list.action";
    }
    @RequestMapping("/edit")
    public String edit(BaseFunction baseFunction, HttpServletRequest request, Model model){
        BaseFunction baseFunction1 = iBaseFunctionService.findById(baseFunction.getFid());
        List<BaseModule> list = iBaseModuleService.findAll();
        model.addAttribute("baseFunction1",baseFunction1);
        request.setAttribute("list",list);
        return "baseFunction/edit";

    }
    @RequestMapping("/update")
    public String update(BaseFunction baseFunction,BaseModule baseModule){
        baseFunction.setMid(baseModule.getMid());
        iBaseFunctionService.updateSelective(baseFunction);
        return "redirect:list.action";

    }
    @RequestMapping("/ajaxList")
    public void ajaxList(HttpServletResponse response, Integer mid, HttpSession session) throws IOException {
        /*List<BaseFunction> list = iBaseFunctionService.findByMid(mid);*/
        BaseUser baseUser = (BaseUser) session.getAttribute("sessionUser");
        List<BaseFunction> list = iBaseFunctionService.findByMid(mid,baseUser.getUserId());
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
    @RequestMapping("/del")
    public String del(BaseFunction baseFunction){
        iBaseFunctionService.delete(baseFunction.getFid());
        return "redirect:list.action";
    }
    @RequestMapping("/search")
    public String search(BaseFunction baseFunction,BaseModule baseModule,Model model,HttpServletRequest request){
        List<BaseFunction> list = iBaseFunctionService.findBys(baseFunction,baseModule);
        request.setAttribute("list",list);
        model.addAttribute("baseFunction",baseFunction);
        model.addAttribute("baseModule",baseModule);
        return "baseFunction/list";
    }
}
