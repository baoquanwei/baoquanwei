/**
 * 
 */
package com.dream.service;

import com.dream.model.User;
import com.pageModel.DataGrid;
import com.pageModel.PageHelper;

/**
 * @author lenovo
 *
 */
public interface UserService {

	/**增加用户*/
	public int addUser(User user);
	
	
	/**分页查找用户信息*/
	public DataGrid getAllUser(PageHelper pg);
	
	/**查询用户名是否存在*/
	public User checkUsername(User user);
	
	/**根据用户id删除用户*/
	public int deleteUser(String id) ;
	
	/**根据用户id获得用户*/
	public User getUser(String id);
	
	/**更新用户*/
	public int updateUser(User u) ;
	
	
	
}
