package com.system.auth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.auth.dao.UBaseUserDao;
import com.system.common.entity.UBaseUser;
import com.system.common.entity.UResRoleResource;
import com.system.common.mapper.UBaseUserMapper;

/**
 * DAO实现层
 * @author LT
 */
@Repository
public class UBaseUserDaoImpl implements UBaseUserDao{
	
    @Autowired
	private UBaseUserMapper uBaseUserMapper;

	@Override
	public UBaseUser selectByPrimaryKey(String userId) {
		UBaseUser baseUser = uBaseUserMapper.selectByPrimaryKey(userId);
		return baseUser;
	}

	@Override
	public int insert(UBaseUser record) {
		uBaseUserMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(UBaseUser record) {
		uBaseUserMapper.insertSelective(record);
		return 0;
	}

	@Override
	//任冰 查询所有用户
    public List<UBaseUser> loadUserData(){
    	List<UBaseUser> list = uBaseUserMapper.loadUserData();
    	return list;
    }
    
	// 任冰 删除用户
	@Override
	public void deleteUser(String userId){
		uBaseUserMapper.deleteUser(userId);
	}
	
	// 任冰 修改用户
	@Override
	public void updateUser(UBaseUser record){
		uBaseUserMapper.updateUser(record);
	}
	
	
}
