package com.knower.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.common.Constants;

/**
 * 错误提示信息处理工具类
 * 
 * @author LT
 *
 */
@Repository
public class  MessageUtil{

	@Autowired  
	HttpServletRequest request; 
	
	public void setErrorMessage(String errorMsg){
		request.getSession().setAttribute(Constants.ERROR_MESSAGE, errorMsg);
	}
	
	public void addErrorMessage(String errorMsg){
		String oldMsg ="";
		if(request.getSession().getAttribute(Constants.ERROR_MESSAGE)!=null){
			oldMsg = request.getSession().getAttribute(Constants.ERROR_MESSAGE).toString();
		}
		StringBuffer msgBuffer = new StringBuffer();
		if("".equals(oldMsg)){
			request.getSession().setAttribute(Constants.ERROR_MESSAGE, errorMsg);
		}else{
			msgBuffer.append(oldMsg);
			msgBuffer.append("<br/>");
			msgBuffer.append(errorMsg);
			request.getSession().setAttribute(Constants.ERROR_MESSAGE, msgBuffer.toString());
		}
	}

	/**
	 * 是否存在错误信息
	 * @return true：存在 false：不存在
	 */
	public boolean isExistError(){
		String oldMsg ="";
		if(request.getSession().getAttribute(Constants.ERROR_MESSAGE)!=null){
			oldMsg = request.getSession().getAttribute(Constants.ERROR_MESSAGE).toString();
		}
		if(StringUtils.isEmpty(oldMsg)){
			return false;
		}
		return true;
	}
}
