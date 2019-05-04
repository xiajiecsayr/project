package com.qhit.baseModule.controller;

        import com.alibaba.fastjson.JSON;
        import com.qhit.baseModule.pojo.BaseModule;
        import com.qhit.baseModule.service.IBaseModuleService;
        import com.qhit.baseModule.service.impl.BaseModuleServiceImpl;
        import org.springframework.http.HttpRequest;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

/**
 * Created by yy on 2018/11/28.
 */
@Controller
@RequestMapping("/baseMoudule")
public class BaseModuleController {
    private IBaseModuleService iBaseModuleService = new BaseModuleServiceImpl();

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        List<BaseModule> list = iBaseModuleService.findAll();
        request.setAttribute("list",list);
        return "baseModule/list";
    }
    @RequestMapping("/lisst")
    public void lisst(HttpServletResponse response) throws IOException {
        List<BaseModule> list = iBaseModuleService.findAll();
        response.getWriter().write(JSON.toJSONString(list));
    }
    @RequestMapping("/insert")
    public String insert(BaseModule baseModule){
        iBaseModuleService.insert(baseModule);
        return "forward:list.action";
    }
    @RequestMapping("/lists")
    public String lists(BaseModule baseModule,HttpServletRequest request){
        List<BaseModule> list = iBaseModuleService.find(baseModule.getMname());
        request.setAttribute("list",list);
        request.setAttribute("baseModule",baseModule);
        return "baseModule/list";
    }
   @RequestMapping("/del")
    public String del(Integer mid){
        iBaseModuleService.delete(mid);
        return "forward:list.action";
   }
   @RequestMapping("/edit")
    public String edit(BaseModule baseModule, Model model){
       BaseModule baseModules = iBaseModuleService.findById(baseModule.getMid());
       model.addAttribute("baseModules",baseModules);
       return "baseModule/edit";
   }
   @RequestMapping("/update")
    public String update(BaseModule baseModuleone){
       iBaseModuleService.update(baseModuleone);
       return "redirect:list.action";
   }
}
