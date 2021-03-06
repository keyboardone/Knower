package com.system.userrole.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knower.common.util.DateUtil;
import com.knower.common.util.UUIDGenerator;
import com.system.common.Constants;
import com.system.userrole.bean.UResUserRoleBean;
import com.system.userrole.dao.UResUserRoleDao;
import com.system.userrole.service.UResUserRoleService;
@Service
public class UResUserRoleServiceImpl implements UResUserRoleService {
    @Autowired
	private UResUserRoleDao userroleDao;
    @Autowired  
    private HttpSession session; 
	
	@Override
	public List<UResUserRoleBean> findUserRoleList(String roleId) {

		List<UResUserRoleBean> userrolelist=userroleDao.findUserRoleList(roleId);
		return userrolelist;
	}


	@Override
	public void insertUserRole(UResUserRoleBean userrole) {
		
		String uuid = UUIDGenerator.getUUID();
		userrole.setId(uuid);
		userroleDao.insertUserRole(userrole);
	}


	@Override
	public void updateUserRole(UResUserRoleBean userrole) {
		
		userroleDao.updateUserRole(userrole);
	}


	@Override
	public void deleteUserRolebyID(String id) {
		// TODO Auto-generated method stub
		userroleDao.deleteUserRolebyID(id);
	}


	@Override
	public List<UResUserRoleBean> selectRole() {
		// TODO Auto-generated method stub
		List<UResUserRoleBean> rolelist=userroleDao.selectRole();
		return rolelist;
	}


	@Override
	public List<UResUserRoleBean> selectUser() {
		// TODO Auto-generated method stub
		List<UResUserRoleBean> userlist=userroleDao.selectUser();
		return userlist;
	}

}
