package com.knower.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.knower.common.entity.UBaseUser;
import com.knower.common.util.ClassReflectUtil;
import com.system.common.Constants;

/**
 * 控制器父类
 * 
 * @author user
 *
 */
@Controller
public abstract class BaseController<T>   {

	/** request */
	protected HttpServletRequest request;
	/** response */
	protected HttpServletResponse response;
	/** session */
	protected HttpSession session;
	/** 每页显示多少条记录 */
	protected Integer pageSize = 100;
	/** 第几页 */
	protected Integer curPage = 1;
	/** 一共有多少条记录 */
	protected Integer totalLines = 0;

    /**
     * 获取交互对象
     * @param request
     * @param response
     */
    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();  
    }
    
    /**
     * 获取用户
     * 
     * @return
     */
    public UBaseUser getUser(){
    	UBaseUser result =new UBaseUser();
    	result.setUserId(this.session.getAttribute(Constants.USER_ID).toString());
		return result;
    	
    }
	 /**
	  * 所有ActionMap 统一从这里获取
	  * @return
	  */
	public Map<String,Object> getRootMap(){
		Map<String,Object> rootMap = new HashMap<String, Object>();
		//添加url到 Map中
		//rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}
	public ModelAndView forword(String viewName,Map context){
		return new ModelAndView(viewName,context); 
	}
	
	public ModelAndView error(String errMsg){
		return new ModelAndView("error"); 
	}
	
    
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin){
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
             CustomDateEditor cust = new CustomDateEditor(sdf,true);
             bin.registerCustomEditor(Date.class,cust);
    }
    /**
     * 设置是否有效和创建用户
     * @param entity
     * @return
     */
    public T setBeanValidAndUser(T entity ){ 
    	try {
			ClassReflectUtil.setIdKeyValue(entity,"validInd","1");
			ClassReflectUtil.setIdKeyValue(entity,"createUser",session.getAttribute(Constants.USER_ID).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return entity;
    }
}
