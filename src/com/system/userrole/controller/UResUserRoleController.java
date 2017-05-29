package com.system.userrole.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.system.userrole.bean.UResUserRoleBean;
import com.system.userrole.service.UResUserRoleService;

@Controller
@RequestMapping(value="/uResUserRoleMV")
public class UResUserRoleController  extends BaseController {
	private static Logger log = Logger.getLogger(UResUserRoleController.class);  
	
	  @Autowired
		private UResUserRoleService userroleService;

	
	
	@RequestMapping(value="",method = RequestMethod.GET)
    public  String init(){
		return "auth/userrole/UResUserRole";
	}
	
	 @ResponseBody
		@RequestMapping(value="/loadData",method = RequestMethod.POST)
		public List<UResUserRoleBean> loadData(String roleId){
			List<UResUserRoleBean> userroleList  = userroleService.findUserRoleList(roleId);
			log.info("This is info message.");  
			log.info("RoleList的size"+userroleList.size());  
			return userroleList;
		}
	 @ResponseBody
	 @RequestMapping(value="/increaseUserRole",method = RequestMethod.POST)
	 public void insertRole(UResUserRoleBean userrole){
		 userroleService.insertUserRole(userrole);
	
	 }
	 @ResponseBody
	 @RequestMapping(value="/updateUserRole",method = RequestMethod.POST)
	 public void updateUserRole(UResUserRoleBean userrole){
		 userroleService.updateUserRole(userrole);
		 
	 }
	 @ResponseBody
	 @RequestMapping(value="/deleteUserRole",method = RequestMethod.POST)
	 public void deleteUserRolebyID(String id){
		 userroleService.deleteUserRolebyID(id);
		 
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/selectRole",method = RequestMethod.POST)
	 public List<UResUserRoleBean> selectRole(){
		 List<UResUserRoleBean> rolelist  = userroleService.selectRole();
		 return rolelist;
		 
		 
	 }
	 @ResponseBody
	 @RequestMapping(value="/selectUser",method = RequestMethod.POST)
	 public List<UResUserRoleBean> selectUser(){
		 List<UResUserRoleBean> userlist  = userroleService.selectUser();
		 return userlist;
		 
		 
	 }
	
}
