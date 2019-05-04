package com.qhit.baseUserRole.controller;

import com.alibaba.fastjson.JSON;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.qhit.baseUserRole.service.IBaseUserRoleService;
import com.qhit.baseUserRole.service.impl.BaseUserRoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yy on 2018/12/23.
 */
@Controller
@RequestMapping("/BaseUserRole")
public class BaseUserRoleController {
    private IBaseUserRoleService baseUserRoleService = new BaseUserRoleServiceImpl();

    @RequestMapping("/list")
    public void list(HttpServletResponse response) throws IOException {
        List<BaseUserRole> list = baseUserRoleService.findSAll();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
}
