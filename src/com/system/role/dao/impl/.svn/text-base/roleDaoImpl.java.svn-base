package com.system.role.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.common.mapper.RoleMapper;
import com.system.role.bean.RoleBean;
import com.system.role.dao.RoleDao;
@Repository
public class roleDaoImpl implements RoleDao {
	   @Autowired
		private RoleMapper roleMapper;

	@Override
	public List<RoleBean> findRoleList() {
		// TODO Auto-generated method stub
		return roleMapper.selectRolelist();
		}

	@Override
	public void insertRole(RoleBean rolebean) {
		// TODO Auto-generated method stub
		roleMapper.insertRole(rolebean);
	}

	@Override
	public void updateRole(RoleBean rolebean) {
		// TODO Auto-generated method stub
		roleMapper.updateRole(rolebean);
	}

	@Override
	public void deleteRolebyID(String roleId) {
		// TODO Auto-generated method stub
		roleMapper.deleteRolebyID(roleId);
	}

}
