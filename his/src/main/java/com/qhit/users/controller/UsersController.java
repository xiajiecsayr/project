package com.qhit.users.controller; 

import com.qhit.users.pojo.Users; 
import com.qhit.users.service.IUsersService; 
import com.qhit.users.service.impl.UsersServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/20
*/
@Controller 
@RequestMapping("/users") 
public class UsersController { 

    IUsersService usersService = new UsersServiceImpl();; 

    @RequestMapping("/insert") 
    public String insert(Users users) { 
        usersService.insert(users); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer uid, HttpServletResponse response) throws IOException { 
        usersService.delete(uid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Users users) { 
        usersService.update(users); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Users users) { 
        usersService.updateSelective(users); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer uid, Model model) { 
        Users users = usersService.findById(uid); 
        model.addAttribute("users",users); 
        return "users/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Users> list = usersService.findAll(); 
        model.addAttribute("list",list); 
        return "users/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Users> list = usersService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Users users,Model model) { 
        List<Users> list = usersService.search(users); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",users); 
        return "users/list"; 
    }
    @RequestMapping("/login")
    public String login(String userName,String password,HttpSession session, Model model){
       Users users = usersService.login(userName,password);
        if(users!=null){
            session.setAttribute("sessionUser",users);
            return "netstorage/xianshi";
        }else {
            model.addAttribute("error","用户名或密码错误！");
            return "dish/login";
        }
    }
 
} 
