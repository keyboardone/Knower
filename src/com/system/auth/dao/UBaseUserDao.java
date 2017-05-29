package com.system.auth.dao;

import java.util.List;

import com.system.common.entity.UBaseUser;
/**
 * DAO接口层
 * 
 * @author LT
 */
public interface UBaseUserDao {

	UBaseUser selectByPrimaryKey(String userId);
	
    int insert(UBaseUser record);

    int insertSelective(UBaseUser record);
	
 //任冰 查询所有用户
    public List<UBaseUser> loadUserData();  
    
 // 任冰 删除用户
    void deleteUser(String userId);
 // 任冰 修改用户
    void updateUser(UBaseUser record);
}
