package com.system.common.mapper;

import java.util.List;

import com.system.common.entity.UResRoleResource;

public interface UResRoleResourceMapper {
	List<UResRoleResource> loadResRoleResourceData();
	void insertResRoleResource(UResRoleResource res);
	void deleteResRoleResource(String roleMenuId);
	void updateResRoleResource(UResRoleResource res);
	
	//角色资源管理需要获取角色id和角色名称
	List<UResRoleResource> getRoleByRoleId();
	//角色资源管理需要获取资源id和资源名称
	List<UResRoleResource> getMenuByMenuId();
}
