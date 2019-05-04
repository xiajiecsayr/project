/*
package com.qhit.common; */
/**
 * Created by yy on 2018/12/19.
 *//*


import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class SpringListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public static Map<String,Object> map;
    public SpringListener() {
        map = new HashMap<>();
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      */
/* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      *//*

      //获取come.qhit的实际路径
        String realPath = sce.getServletContext().getRealPath("come/qhit");
        //创建file对象
        File file = new File(realPath);
        //对该对象进行递归处理
        listFile(file);
        String absolutePath = file.getAbsolutePath();
        //获取类的路径 包名+路名
        String ClassPath = absolutePath.substring(absolutePath.indexOf("com/"), absolutePath.indexOf(".class")).replaceAll("/", ".");//replaceAll替换
        try {
            //获取类对象
            Class<?> clazz = Class.forName(ClassPath);
            //获取类型为Controller,Service,Repository,Component的注解
            Controller contrller = (Controller) clazz.getAnnotation(Controller.class);
            Service serviceervice = (Service) clazz.getAnnotation(Service.class);
            Repository repository = (Repository) clazz.getAnnotation(Repository.class);
            Component component = (Component) clazz.getAnnotation(Component.class);
            String ClassName = ClassPath.substring(ClassPath.indexOf(".") + 1);
            String key = null;
            if(contrller!=null){
                key = contrller.value();
            }
            if(serviceervice!=null){
                key = serviceervice.value();
            }
            if(repository!=null){
                key = repository.value();
            }
            if(component!=null){
                key = component.value();
            }
            if(key!=null){
                if("".equals(key)){
                    key= BaseDao.toLowerCaseFirstOne(ClassName).replace("Impl","");
                }
                map.put(key,clazz.newInstance());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    private void listFile(File file) {
        //如果是文件夹
        if(file.isDirectory()){
            //获取它下面的所有文件
            File[] files = file.listFiles();
            for (File f:files){
                listFile(f);
            }
        }else {
            System.out.println("文件的全路径："+file.getAbsolutePath());
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      */
/* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      *//*

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      */
/* Session is created. *//*

    }

    public void sessionDestroyed(HttpSessionEvent se) {
      */
/* Session is destroyed. *//*

    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      */
/* This method is called when an attribute
         is added to a session.
      *//*

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      */
/* This method is called when an attribute
         is removed from a session.
      *//*

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      */
/* This method is invoked when an attibute
         is replaced in a session.
      *//*

    }
}
*/
