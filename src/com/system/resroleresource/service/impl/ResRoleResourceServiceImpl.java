package com.system.resroleresource.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knower.common.util.DateUtil;
import com.knower.common.util.UUIDGenerator;
import com.system.common.Constants;
import com.system.common.entity.UResRoleResource;
import com.system.resroleresource.dao.ResRoleResourceDao;
import com.system.resroleresource.service.ResRoleResourceService;

@Service
public class ResRoleResourceServiceImpl implements ResRoleResourceService {
	@Autowired
	private ResRoleResourceDao resDao;
	@Autowired
	private HttpSession session;
	
	public List<UResRoleResource> loadResRoleResourceData(){
    	List<UResRoleResource> list = resDao.loadResRoleResourceData();
    	return list;
    }
	
	public void insertResRoleResource(UResRoleResource res){
		String roleMenuId = UUIDGenerator.getUUID();
		res.setRoleMenuId(roleMenuId);
		
		resDao.insertResRoleResource(res);
	}
	
	//任冰 删除资源 需要校验
	public void deleteResRoleResource(String roleMenuId){
		/**
		 * 从角色资源关系表中，根据 roleMenuId 找到roleId和menuId
		 * 从菜单表中，以menuId为参照，搜索所有的menuParentId=menuId的行数据
		 * 从角色资源关系表中，根据这些行数据中的menuId，
		 */
		resDao.deleteResRoleResource(roleMenuId);
	}
	
	
	public void updateResRoleResource(UResRoleResource res){
		
		resDao.updateResRoleResource(res);
	}
	
	// 任冰 角色资源管理需要获取角色id和角色名称
	public List<UResRoleResource> getRoleByRoleId(){
		List<UResRoleResource> list = resDao.getRoleByRoleId();
		return list;
	}
	// 任冰 角色资源管理需要获取资源id和资源名称
	public List<UResRoleResource> getMenuByMenuId(){
		List<UResRoleResource> list = resDao.getMenuByMenuId();
		return list;
	}
}
