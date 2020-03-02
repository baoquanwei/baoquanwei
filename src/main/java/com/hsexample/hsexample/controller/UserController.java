package com.hsexample.hsexample.controller;


import com.hsexample.hsexample.entity.User;
import com.hsexample.hsexample.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/testboot")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String Sel(@PathVariable int id){
         userService.Sel(id);
        return userService.Sel(id).toString();
    }

    @RequestMapping("login")
    public String Tologin(){
        return "login";
    }

    @RequestMapping("checklogin")
    @ResponseBody
    public int checklogin(HttpServletRequest request, HttpSession session, String loginName, String password ){
        int ucount=userService.shechuser(loginName);
        int ccount=userService.checkuser(loginName,password);

        if(ucount>0){
            if (ccount>0){
                return 2;
            }else{
                return 1;
            }
        }else {
            return 0;
        }


    }
    @RequestMapping("tologin")
    public String  login( HttpSession session, String loginName) {
        List<Map<String, Object>> ulist=new ArrayList<>();
        /*ulist=userService.queryuserbyloginName(loginName);*/
        ulist=userService.queryall();
        session.setAttribute("Msg",ulist.get(0).get("userName"));
        session.setAttribute("ulist",ulist);
        return "table";

    }
}


