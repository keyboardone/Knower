package com.system.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.base.dao.UBaseMenuDao;
import com.system.common.entity.UBaseMenu;
import com.system.common.mapper.UBaseMenuMapper;

/**
 * DAO实现层
 * @author LT
 */
@Repository
public class UBaseMenuDaoImpl implements UBaseMenuDao{
	
    @Autowired
	private UBaseMenuMapper uBaseMenuMapper;

	@Override
	public List<UBaseMenu> getMenuList(String userId) {
		List<UBaseMenu> baseMenus =uBaseMenuMapper.getMenuList(userId);
		return baseMenus;
	}

	@Override
	//新增菜单
	public int insert(UBaseMenu record) {
		uBaseMenuMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(UBaseMenu record) {
		return 0;
	}
	
	//加载所有菜单
	public List<UBaseMenu> getAllMenuList(){
		List<UBaseMenu> menulist=uBaseMenuMapper.getAllMenuList();
		return menulist;
	}
	
	//任冰 修改菜单
	public void updateMenu(UBaseMenu record){
		uBaseMenuMapper.updateMenu(record);
	}
	
	//任冰 删除菜单
	public void deleteMenu(String menuId){
		uBaseMenuMapper.deleteMenu(menuId);
	}
	
	//任冰 删除菜单校验
	public List<UBaseMenu> deleteMenuCheck(String menuId){
		List<UBaseMenu> deleteMenuCheck=uBaseMenuMapper.deleteMenuCheck(menuId);
		return deleteMenuCheck;
	}

}
