package com.hsexample.hsexample.mapper;


import com.hsexample.hsexample.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface Usermapper {

  public User Sel (int id);
  public int seacheuser(String loginName);
  public int checkuser(String loginName,String password);
  public List<Map<String,Object>> queryuserbyloginName(String loginName);
  public List<Map<String,Object>> queryall();
}
