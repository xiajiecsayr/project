package com.qhit.common;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseManufacturer.pojo.BaseManufacturer;
import com.qhit.baseUser.pojo.BaseUser;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yy on 2018/12/14.
 */
@Component
@Aspect
public class authorityInterceptor {
    @Before(value = "execution(* com.qhit.*.controller.*.*(..))")
    public void before(){
        //	从普通类中获取request的方式：
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        BaseUser baseUser = (BaseUser)session.getAttribute("sessionUser");
//        BaseUser sessionUser = (BaseUser) request.getSession().getAttribute("sessionUser");
        if(baseUser!=null){
            //判断用户是否拥有权限
            //用户发送的权限
            String requestURI = request.getRequestURI();
            //用户拥有的功能
            List<BaseFunction> baseFunctionList = baseUser.getBaseFunctionList();
            //查看是否拥有该功能
            boolean flag = false;
            for (BaseFunction baseFunction:baseFunctionList){
                String url = baseFunction.getUrl();
                if(baseFunction.getUrl()!=null&&requestURI.indexOf(url)!=-1){
                    flag = true;
                    break;
                }
            }

            request.setAttribute("flags",flag);
        }

    }
}
