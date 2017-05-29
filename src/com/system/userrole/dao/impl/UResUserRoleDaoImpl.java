package com.system.userrole.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.common.mapper.UResUserRoleMapper;
import com.system.userrole.bean.UResUserRoleBean;
import com.system.userrole.dao.UResUserRoleDao;

@Repository
public class UResUserRoleDaoImpl implements UResUserRoleDao {
	   @Autowired
		private UResUserRoleMapper userroleMapper;

	@Override
	public List<UResUserRoleBean> findUserRoleList(String roleId) {
		// TODO Auto-generated method stub
		return userroleMapper.selectUserRolelist(roleId);
		}

	@Override
	public void insertUserRole(UResUserRoleBean userrole) {
		// TODO Auto-generated method stub
		userroleMapper.insertUserRole(userrole);
	}

	@Override
	public void updateUserRole(UResUserRoleBean userrole) {
		// TODO Auto-generated method stub
		userroleMapper.updateUserRole(userrole);
	}

	@Override
	public void deleteUserRolebyID(String id) {
		// TODO Auto-generated method stub
		userroleMapper.deleteUserRolebyID(id);
	}

	@Override
	public List<UResUserRoleBean> selectRole() {
		// TODO Auto-generated method stub
		return userroleMapper.selectRole();
	}

	@Override
	public List<UResUserRoleBean> selectUser() {
		// TODO Auto-generated method stub
		return userroleMapper.selectUser();
	}

}
