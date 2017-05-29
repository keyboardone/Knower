package com.system.role.dao;

import java.util.List;

import com.system.role.bean.RoleBean;

public interface RoleDao {

	List<RoleBean> findRoleList();

	void insertRole(RoleBean rolebean);

	void updateRole(RoleBean rolebean);

	void deleteRolebyID(String roleId);

}
