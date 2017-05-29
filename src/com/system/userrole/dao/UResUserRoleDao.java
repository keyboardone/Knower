package com.system.userrole.dao;

import java.util.List;

import com.system.userrole.bean.UResUserRoleBean;

public interface UResUserRoleDao {

	List<UResUserRoleBean> findUserRoleList(String roleId);

	void insertUserRole(UResUserRoleBean userrole);

	void updateUserRole(UResUserRoleBean userrole);

	void deleteUserRolebyID(String id);
	
	List<UResUserRoleBean> selectRole();
	
	List<UResUserRoleBean> selectUser();

}
