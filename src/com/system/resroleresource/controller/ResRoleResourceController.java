package com.system.resroleresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.system.common.entity.UResRoleResource;
import com.system.resroleresource.service.ResRoleResourceService;

@Controller
@RequestMapping(value="/ResRoleResourceController")
public class ResRoleResourceController extends BaseController {
	@Autowired
	private ResRoleResourceService resService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
    public  String init(){
		return "auth/resroleresource/resroleresource";
	}
	
	@ResponseBody
	@RequestMapping(value="/loadResRoleResourceData",method = RequestMethod.POST)
	public List<UResRoleResource> loadResRoleResourceData(){
		List<UResRoleResource> list =  resService.loadResRoleResourceData();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertResRoleResource",method = RequestMethod.POST)
	public void insertResRoleResource(UResRoleResource res){
		resService.insertResRoleResource(res);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteResRoleResource",method = RequestMethod.POST)
	public void deleteResRoleResource(String roleMenuId){
		resService.deleteResRoleResource(roleMenuId);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateResRoleResource",method = RequestMethod.POST)
	public void updateResRoleResource(UResRoleResource res){
		resService.updateResRoleResource(res);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRoleByRoleId",method = RequestMethod.POST)
	public List<UResRoleResource> getRoleByRoleId(){
		List<UResRoleResource> list = resService.getRoleByRoleId();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/getMenuByMenuId",method = RequestMethod.POST)
	public List<UResRoleResource> getMenuByMenuId(){
		List<UResRoleResource> list = resService.getMenuByMenuId();
		return list;
	}
}
