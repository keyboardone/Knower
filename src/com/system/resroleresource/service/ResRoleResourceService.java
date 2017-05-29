package com.system.resroleresource.service;

import java.util.List;

import com.system.common.entity.UResRoleResource;

public interface ResRoleResourceService {

	public List<UResRoleResource> loadResRoleResourceData();

	public void insertResRoleResource(UResRoleResource res);

	public void deleteResRoleResource(String roleMenuId);

	public void updateResRoleResource(UResRoleResource res);

	//角色资源管理需要获取角色id和角色名称
	List<UResRoleResource> getRoleByRoleId();
	//角色资源管理需要获取资源id和资源名称
	List<UResRoleResource> getMenuByMenuId();
}