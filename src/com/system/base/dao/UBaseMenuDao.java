package com.system.base.dao;

import java.util.List;

import com.system.base.bean.MenuBean;
import com.system.common.entity.UBaseMenu;
/**
 * DAO接口层
 * 
 * @author LT
 */
public interface UBaseMenuDao {
	
	List<UBaseMenu> getMenuList(String userId);
	
	//新增菜单
    int insert(UBaseMenu record);

    int insertSelective(UBaseMenu record);

    //加载所有菜单
	List<UBaseMenu> getAllMenuList();
	
	//任冰 修改菜单
	void updateMenu(UBaseMenu record); 
	
	//任冰 删除菜单
	void deleteMenu(String menuId);
	
	//任冰 删除菜单校验
	public List<UBaseMenu> deleteMenuCheck(String menuId);
}
