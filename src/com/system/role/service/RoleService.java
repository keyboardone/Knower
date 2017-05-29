package com.system.role.service;

import java.util.List;

import com.system.role.bean.RoleBean;

public interface RoleService {
	public List<RoleBean> findRoleList() ;

	public void insertRole(RoleBean rolebean);

	public void updateRole(RoleBean rolebean);

	public void deleteRolebyID(String roleId);
}
