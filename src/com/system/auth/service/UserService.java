package com.system.auth.service;

import java.util.List;

import com.system.auth.bean.UserBean;
import com.system.common.entity.UBaseUser;


public interface UserService {
   
	public UserBean findUserById(String userId) ;
	
 // 任冰 新增用户
	int insert(UBaseUser record);
 
 //任冰 查询所有用户
    public List<UBaseUser> loadUserData();
	
 // 任冰 删除用户
    void deleteUser(String userId);
    
 // 任冰 修改用户
    void updateUser(UBaseUser record);
}
