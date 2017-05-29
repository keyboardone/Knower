package com.system.resroleresource.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.common.entity.UResRoleResource;
import com.system.common.mapper.UResRoleResourceMapper;
import com.system.resroleresource.dao.ResRoleResourceDao;

@Repository
public class ResRoleResourceDaoImpl implements ResRoleResourceDao {
	@Autowired
	private UResRoleResourceMapper resMapper;
	
	public List<UResRoleResource> loadResRoleResourceData(){
		List<UResRoleResource> list =  resMapper.loadResRoleResourceData();
		return list;
	}
	
	public void insertResRoleResource(UResRoleResource res){
		resMapper.insertResRoleResource(res);
	}
	
	public void deleteResRoleResource(String roleMenuId){
		resMapper.deleteResRoleResource(roleMenuId);
	}
	
	public void updateResRoleResource(UResRoleResource res){
		resMapper.updateResRoleResource(res);
	}
	
	// 任冰 角色资源管理需要获取角色id和角色名称
	public List<UResRoleResource> getRoleByRoleId(){
		List<UResRoleResource> list = resMapper.getRoleByRoleId();
		return list;
	}
	// 任冰 角色资源管理需要获取资源id和资源名称
	public List<UResRoleResource> getMenuByMenuId(){
		List<UResRoleResource> list = resMapper.getMenuByMenuId();
		return list;
	}
}
