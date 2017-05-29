package com.system.common.mapper;

import java.util.List;

import com.system.role.bean.RoleBean;

public interface RoleMapper {

	List<RoleBean> selectRolelist();

	void insertRole(RoleBean rolebean);

	void updateRole(RoleBean rolebean);

	void deleteRolebyID(String roleId);

}
