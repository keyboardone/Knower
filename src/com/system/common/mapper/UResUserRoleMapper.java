package com.system.common.mapper;

import java.util.List;

import com.system.userrole.bean.UResUserRoleBean;


public interface UResUserRoleMapper {

	List<UResUserRoleBean> selectUserRolelist(String roleId);

	void insertUserRole(UResUserRoleBean userrole);

	void updateUserRole(UResUserRoleBean userrole);

	void deleteUserRolebyID(String id);
	
	List<UResUserRoleBean> selectRole();
	
	List<UResUserRoleBean> selectUser();

}
