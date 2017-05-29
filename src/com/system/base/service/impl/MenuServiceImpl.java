package com.system.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.base.bean.MenuBean;
import com.system.base.dao.UBaseMenuDao;
import com.system.base.service.MenuService;
import com.system.common.Constants;
import com.system.common.entity.UBaseMenu;

@Service
public class MenuServiceImpl  implements MenuService{

    @Autowired
	private UBaseMenuDao uBaseMenuDao;

    /**
     * 获取菜单列表
     */
	@Override
	public List<MenuBean> getMenuList(String userId) {
		List<MenuBean> result = new ArrayList<MenuBean>();
		List<UBaseMenu> baseMenus = uBaseMenuDao.getMenuList(userId);
		for(UBaseMenu baseMenu :baseMenus){
			MenuBean bean =new MenuBean();
			if(Constants.TREE_PARENT_NODE.equals(baseMenu.getMenuParentId())){
				BeanUtils.copyProperties(baseMenu, bean);
				this.findSubMenuList(bean, baseMenus);
				result.add(bean);
			}
		}
		return result;
	}
	
	/**
	 * 获取所有菜单信息
	 */
	public List<UBaseMenu> getAllMenuList(){
		List<UBaseMenu> menulist=uBaseMenuDao.getAllMenuList();
		
		return menulist;
	}
	
	
	/**
	 * 递归寻找下级菜单
	 * 
	 * @param targetMenu
	 * @param baseMenus
	 * @return
	 */
	private MenuBean findSubMenuList(MenuBean targetMenu,List<UBaseMenu> baseMenus){
		List<MenuBean> subMenuList = new ArrayList<MenuBean>();
		
		boolean hasSubFlg = true;
		for(UBaseMenu baseMenu :baseMenus){
			if(targetMenu.getMenuId().equals(baseMenu.getMenuParentId())){
				hasSubFlg = false;
			}
		}
		// 如果不存在子菜单，跳出递归
		if(hasSubFlg){
			return targetMenu;
		}
		for(UBaseMenu baseMenu :baseMenus){
			MenuBean bean =new MenuBean();
			if(targetMenu.getMenuId().equals(baseMenu.getMenuParentId())){
				BeanUtils.copyProperties(baseMenu, bean);
				this.findSubMenuList(bean, baseMenus);
				subMenuList.add(bean);
			}
		}
		targetMenu.setSubMenuList(subMenuList);
		return targetMenu;
	}
	
	//新增菜单
	public int insert(UBaseMenu record) {
		uBaseMenuDao.insert(record);
		return 0;
	}
	
	//任冰 修改菜单
	public void updateMenu(UBaseMenu record){
		uBaseMenuDao.updateMenu(record);
	}
	//任冰 删除菜单校验
	
	
	//任冰 删除菜单
	public void deleteMenu(String menuId){
		uBaseMenuDao.deleteMenu(menuId);
	}
	
	//任冰 删除菜单校验
	public boolean deleteMenuCheck(String menuId){
		boolean menuCheckInfo = true;
		List<UBaseMenu> deleteMenuCheck = uBaseMenuDao.deleteMenuCheck(menuId);
		if(deleteMenuCheck.size()==0){
			menuCheckInfo = false;
		}
		return menuCheckInfo;
	}
}
