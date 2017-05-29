package com.system.base.service;

import java.util.List;

import com.system.base.bean.MenuBean;
import com.system.common.entity.UBaseMenu;


public interface MenuService {
   
	public  List<MenuBean> getMenuList(String userId) ;
	
	//加载所有菜单
	public List<UBaseMenu> getAllMenuList();
	
	//新增菜单
	int insert(UBaseMenu record);
	
	//任冰 修改菜单
	public void updateMenu(UBaseMenu record); 
	
	//任冰 删除菜单
	public void deleteMenu(String menuId);
	
	//任冰 删除菜单校验
	public boolean deleteMenuCheck(String menuId);
}
