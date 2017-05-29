package com.system.base.controller;

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
import com.system.base.service.MenuService;
import com.system.common.entity.UBaseMenu;

@Controller
@RequestMapping(value="/ubaseMenuMV")
public class MenuListController extends BaseController{
    @Autowired
	private MenuService menuService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public  String init(){
		return "auth/menu/menu";
	}

    @ResponseBody
 	@RequestMapping(value="/loadData",method = RequestMethod.GET)
     public  Map<String,String> getAllMenuList(String id){
     
     	List<UBaseMenu> result =  menuService.getAllMenuList();
     	
     	String loop = loop(result,id);
     	loop="当前位置:   >>"+loop;
     	Map<String,String> resultMap = new HashMap<String,String>();
     	 resultMap.put("data",loop);
 		return resultMap;
 	}
    
    
    public String loop(List<UBaseMenu> result, String id){
    	
    	String showmeg="";
    	for(int i=0;i<result.size();i++){
    		
    		if(id.equals(result.get(i).getMenuId())){
    			if(showmeg==""){
    			showmeg=result.get(i).getMenuName();
    			}else {
    			showmeg=result.get(i).getMenuName()+"   >>  "+showmeg;
    			}
    			id=result.get(i).getMenuParentId();
    			if(id=="-1"){
    				break;
    			}
    			i=-1;
    		}
    	}
    	return showmeg;
    }
    
    @ResponseBody
 	@RequestMapping(value="/getAllMenuList",method = RequestMethod.POST)
 	public List<UBaseMenu> getAllMenuList(){
		List<UBaseMenu> menulist=menuService.getAllMenuList();
		return menulist;
	}
    // 导出
	@ResponseBody
	@RequestMapping(value = "/exportMenu", method = RequestMethod.GET)
	public void exportTree() throws Exception {
		
		String jsondata = request.getParameter("ds");
		jsondata = new String(jsondata.getBytes("ISO-8859-1"), "UTF-8"); 
		String[] textAndDatafieldTemp = jsondata.split("-");
		
		String[] titles = textAndDatafieldTemp[0].split(",");
		String[] datafieldArray = textAndDatafieldTemp[1].split(",");
		List<UBaseMenu> tree = menuService.getAllMenuList();
		UBaseMenu midRefPortfolioInfo = new UBaseMenu();
		Map<String, String> BeanToMap = new HashMap();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		for(int i=0;i<tree.size();i++){
			midRefPortfolioInfo = tree.get(i);
			BeanToMap = BeanUtils.describe(midRefPortfolioInfo);
			listMap.add(BeanToMap);
		}
		String fileName = "菜单信息";
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes(),"iso-8859-1") + ".xls");
		
		ServletOutputStream out = response.getOutputStream();
		ExportExcelUtil.exportExcel(fileName, listMap, titles, datafieldArray, out);
	}
    @ResponseBody
 	@RequestMapping(value="/insertMenu",method = RequestMethod.POST)
 	public int insert(UBaseMenu record) {
    	menuService.insert(record);
		return 0;
	}
    
    @ResponseBody
 	@RequestMapping(value="/updateMenu",method = RequestMethod.POST)
 	public void updateMenu(UBaseMenu record){
    	menuService.updateMenu(record);
	}
    
    @ResponseBody
 	@RequestMapping(value="/deleteMenu",method = RequestMethod.POST)
 	public void deleteMenu(String menuId){
    	menuService.deleteMenu(menuId);
	}
    
    @ResponseBody
    @RequestMapping(value="/deleteMenuCheck",method = RequestMethod.POST)
    public boolean deleteMenuCheck(String menuId){
		boolean menuCheckInfo = true;
		menuCheckInfo = menuService.deleteMenuCheck(menuId);
		return menuCheckInfo;
	}
}
