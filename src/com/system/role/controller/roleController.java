package com.system.role.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.knower.common.util.ExportExcelUtil;
import com.system.role.bean.RoleBean;
import com.system.role.service.RoleService;


@Controller
@RequestMapping(value="/ubaseRoleMV")
public class roleController  extends BaseController {
	private static Logger log = Logger.getLogger(roleController.class);  
	
	  @Autowired
		private RoleService roleService;

	
	
	@RequestMapping(value="",method = RequestMethod.GET)
    public  String init(){
		return "auth/role/RoleManager";
	}
	
	 @ResponseBody
		@RequestMapping(value="/loadData",method = RequestMethod.POST)
		public List<RoleBean> loadData(){
			List<RoleBean> roleList  = roleService.findRoleList();
			log.info("This is info message.");  
			log.info("RoleList的size"+roleList.size());  
			return roleList;
		}
	 // 导出角色信息
	@ResponseBody
	@RequestMapping(value = "/exportRole", method = RequestMethod.GET)
	public void exportTree() throws Exception {
		
		String jsondata = request.getParameter("ds");
		jsondata = new String(jsondata.getBytes("ISO-8859-1"), "UTF-8"); 
		String[] textAndDatafieldTemp = jsondata.split("-");
		
		String[] titles = textAndDatafieldTemp[0].split(",");
		String[] datafieldArray = textAndDatafieldTemp[1].split(",");
		List<RoleBean> tree = roleService.findRoleList();
		RoleBean midRefPortfolioInfo = new RoleBean();
		Map<String, String> BeanToMap = new HashMap();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		for(int i=0;i<tree.size();i++){
			midRefPortfolioInfo = tree.get(i);
			BeanToMap = BeanUtils.describe(midRefPortfolioInfo);
			listMap.add(BeanToMap);
		}
		String fileName = "角色信息";
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes(),"iso-8859-1") + ".xls");
		
		ServletOutputStream out = response.getOutputStream();
		ExportExcelUtil.exportExcel(fileName, listMap, titles, datafieldArray, out);
	}
	 @ResponseBody
	 @RequestMapping(value="/increaseRole",method = RequestMethod.POST)
	 public void insertRole(RoleBean rolebean){
		 roleService.insertRole(rolebean);
	
	 }
	 @ResponseBody
	 @RequestMapping(value="/updateRole",method = RequestMethod.POST)
	 public void updateRole(RoleBean rolebean){
		 roleService.updateRole(rolebean);
		 
	 }
	 @ResponseBody
	 @RequestMapping(value="/deleteRole",method = RequestMethod.POST)
	 public void deleteRolebyID(String roleId){
		 roleService.deleteRolebyID(roleId);
		 
	 }
	
}
