package com.hsexample.hsexample.service.serviceImpl;

import com.hsexample.hsexample.entity.User;
import com.hsexample.hsexample.mapper.Usermapper;
import com.hsexample.hsexample.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    Usermapper usermapper;
    @Override
    public User Sel(int id) {
        return usermapper.Sel(id);
    }

    @Override
    public int shechuser(String loginName) {
        return usermapper.seacheuser(loginName);
    }

    @Override
    public int checkuser(String loginName, String password) {
        return usermapper.checkuser(loginName,password);
    }

    @Override
    public List<Map<String, Object>> queryuserbyloginName(String loginName) {
        return usermapper.queryuserbyloginName(loginName);
    }

    @Override
    public List<Map<String, Object>> queryall() {
        return usermapper.queryall();
    }
}
