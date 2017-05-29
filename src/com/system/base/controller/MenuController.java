package com.system.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.system.base.bean.MenuBean;
import com.system.base.service.MenuService;

@Controller
public class MenuController extends BaseController{
	
	
    @Autowired
	private MenuService menuService;

    @ResponseBody
	@RequestMapping(value="menu",method = RequestMethod.GET)
    public  List<MenuBean> init(){
    	//登录用户时获取到他的user_id
    	String userId=(String) session.getAttribute("userid");
//    	System.out.println(userId);
    	List<MenuBean> result =  menuService.getMenuList(userId);
		return result;
	}
    

    
    
}
