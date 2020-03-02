package com.hsexample.hsexample.service;

import com.hsexample.hsexample.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {


    public User Sel(int id);
    public int shechuser(String loginName);
    public int checkuser(String loginName,String password);
    public List<Map<String, Object>> queryuserbyloginName(String loginName);
    public List<Map<String,Object>> queryall();

}
