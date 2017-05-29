package com.system.auth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.knower.common.util.ExportExcelUtil;
import com.system.auth.service.UserService;
import com.system.common.entity.UBaseUser;

@Controller
@RequestMapping(value="/UserController")
public class UserController extends BaseController {
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="",method = RequestMethod.GET)
    public  String init(){
		return "auth/user/user";
	}
	
	//用户信息查询
    //任冰
	@ResponseBody
	@RequestMapping(value="/loadUserData",method = RequestMethod.POST)
    public List<UBaseUser> findUserById(String userId){
		List<UBaseUser> list = userservice.loadUserData();
    	return list;
    }
	// 导出
	@ResponseBody
	@RequestMapping(value = "/exportUser", method = RequestMethod.GET)
	public void exportTree() throws Exception {
		
		String jsondata = request.getParameter("ds");
		jsondata = new String(jsondata.getBytes("ISO-8859-1"), "UTF-8"); 
		String[] textAndDatafieldTemp = jsondata.split("-");
		
		String[] titles = textAndDatafieldTemp[0].split(",");
		String[] datafieldArray = textAndDatafieldTemp[1].split(",");
		List<UBaseUser> tree = userservice.loadUserData();
		UBaseUser midRefPortfolioInfo = new UBaseUser();
		Map<String, String> BeanToMap = new HashMap();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		for(int i=0;i<tree.size();i++){
			midRefPortfolioInfo = tree.get(i);
			BeanToMap = BeanUtils.describe(midRefPortfolioInfo);
			listMap.add(BeanToMap);
		}
		String fileName = "用户信息";
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes(),"iso-8859-1") + ".xls");
		
		ServletOutputStream out = response.getOutputStream();
		ExportExcelUtil.exportExcel(fileName, listMap, titles, datafieldArray, out);
	}
	@ResponseBody
	@RequestMapping(value="/loadUser",method = RequestMethod.POST)
    public List<UBaseUser> loadUser(){
		List<UBaseUser> userlist = userservice.loadUserData();
    	return userlist;
    }
	
	//用户信息删除
    //任冰
	@ResponseBody
	@RequestMapping(value="/deleteUser",method = RequestMethod.POST)
    public void deleteProxyRule(String userId){
		userservice.deleteUser(userId);
    	
    }
	
	//用户信息新增
    //任冰
	@ResponseBody
	@RequestMapping(value="/insertUser",method = RequestMethod.POST)
    public int insert(UBaseUser record) {
		userservice.insert(record);
		return 0;
	}
	
	//用户信息修改
    //任冰
	@ResponseBody
	@RequestMapping(value="/updateUser",method = RequestMethod.POST)
	public void updateUser(UBaseUser record){
		userservice.updateUser(record);
	}
}
