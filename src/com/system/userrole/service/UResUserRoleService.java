package com.system.userrole.service;

import java.util.List;

import com.system.userrole.bean.UResUserRoleBean;


public interface UResUserRoleService {
	public List<UResUserRoleBean> findUserRoleList(String roleId) ;

	public void insertUserRole(UResUserRoleBean userrole);

	public void updateUserRole(UResUserRoleBean userrole);

	public void deleteUserRolebyID(String id);
	
	public List<UResUserRoleBean> selectRole() ;
	
	public List<UResUserRoleBean> selectUser() ;
}
