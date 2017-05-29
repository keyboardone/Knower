package com.system.role.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knower.common.util.DateUtil;
import com.knower.common.util.UUIDGenerator;
import com.system.common.Constants;
import com.system.role.bean.RoleBean;
import com.system.role.dao.RoleDao;
import com.system.role.service.RoleService;
@Service
public class roleServiceImpl implements RoleService {
    @Autowired
	private RoleDao roleDao;
    @Autowired  
    private HttpSession session; 
	
	@Override
	public List<RoleBean> findRoleList() {

		List<RoleBean> rolelist=roleDao.findRoleList();
		return rolelist;
	}


	@Override
	public void insertRole(RoleBean rolebean) {
		String uuid = UUIDGenerator.getUUID();
		rolebean.setRoleId(uuid);
		roleDao.insertRole(rolebean);
	}


	@Override
	public void updateRole(RoleBean rolebean) {
		roleDao.updateRole(rolebean);
	}


	@Override
	public void deleteRolebyID(String roleId) {
		// TODO Auto-generated method stub
		roleDao.deleteRolebyID(roleId);
	}

}
