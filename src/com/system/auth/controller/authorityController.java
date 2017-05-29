package com.system.auth.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knower.common.controller.BaseController;
import com.knower.common.util.DateUtil;
import com.knower.common.util.HexUtils;
import com.system.auth.bean.UserBean;
import com.system.auth.service.UserService;
import com.system.common.Constants;
import com.system.common.entity.UBaseUser;
import com.system.error.bean.ErrorBean;
import com.system.error.service.ErrorService;

@Controller
public class authorityController extends BaseController{
	
	@Autowired
	private HttpServletRequest request;
    @Autowired
	private UserService userService;
    @Autowired
	private ErrorService errorService;
    String error="OK";
    
	@RequestMapping(value="/",method = RequestMethod.GET)
    public  String init(){
		return "common/login";
	}
	
	@RequestMapping(value="/loginIndex",method = RequestMethod.GET)
    public  String loginIndex(){
		return "common/index";
	}
    
	@ResponseBody
	@RequestMapping(value="/login.do",method = RequestMethod.POST)
    public  String login(UserBean userBean) {
		String userId="";
		//判断login.jsp传过来的用户信息是否为空
		if (userBean !=null && StringUtils.isNotEmpty(userBean.getUserId())){
			//查找所用的用户信息
			List<UBaseUser> bean=userService.loadUserData();
			userId=userBean.getUserId();
			for(int z=0;z<bean.size();z++){
				//判断用户是否存在
				if(userBean.getUserId().equals(bean.get(z).getUserId())){
					session.setAttribute("username", bean.get(z).getUserCname());
					session.setAttribute("userid", bean.get(z).getUserId());
					super.session.setAttribute(Constants.USER_ID, bean.get(z).getUserId());
					//查询用户表中该用户的信息
					UserBean bean2 = userService.findUserById(userBean.getUserId());
					//查找错误表中的用户信息
					ErrorBean errorBean=errorService.selectErrorByUserId(userId);
					//判断用户密码是否正确
					if(userBean.getPassword().equals(bean2.getPassword())){
						//判断异常信息表中的数据是否为空
						if(errorBean!=null){
							int count2=Integer.parseInt(errorBean.getErrorCount());
							//判断异常表中该用户登录异常的次数是否>5
							if(count2>=5){
								String errorDate=errorBean.getErrorDate();
								String dateTime = DateUtil.getDateTime(new Date(),"");
								long dc=0;
								//把时间格式转换成字符格式
								String dt="";
								String[] a1 =dateTime.split("-");
								for(int n=0;n<a1.length;n++){
									dt=dt+a1[n];
								}
								String[] b1=dt.split(" ");
								dt="";
								for(int n=0;n<b1.length;n++){
									dt=dt+b1[n];
								}
								String[] c1=dt.split(":");
								dt="";
								for(int n=0;n<c1.length;n++){
									dt=dt+c1[n];
								}
								//把时间格式转换成字符格式
								String rD="";
								String[] a2 =errorDate.split("-");
								for(int n=0;n<a2.length;n++){
									rD=rD+a2[n];
								}
								String[] b2=rD.split(" ");
								rD="";
								for(int n=0;n<b2.length;n++){
									rD=rD+b2[n];
								}
								String[] c2=rD.split(":");
								rD="";
								for(int n=0;n<c2.length;n++){
									rD=rD+c2[n];
								}
								if(Long.parseLong(dt.substring(0, dt.length()-4))>Long.parseLong(rD.substring(0, rD.length()-4))){
									 dc=(Long.parseLong(dt)-4000-Long.parseLong(rD))/100;
								}else{
									 dc=(Long.parseLong(dt)-Long.parseLong(rD))/100;
								}
								//判断时候现在时间和该用户被锁定的时间是否>30分钟
								if(dc>=30){
									error="OK";
									errorService.deleteError(userId);
									return error;
								}else{
									error="该用户已被冻结,"+String.valueOf(30-dc)+"分钟后可正常登录";
									return error;
								}
							}else{
								error="OK";
								errorService.deleteError(userId);
								return error;
							}
						}else{
							error="OK";
//							errorService.deleteError(userId);
							return error;
						}
					}else{
						//判断异常信息表中的数据是否为空
						if(errorBean!=null){
							//判断异常表中该用户登录异常的次数是否<5
							if(Integer.parseInt(errorBean.getErrorCount())<4){
								errorBean.setUserId(userId);
								String dateTime = DateUtil.getDateTime(new Date(),"");
								errorBean.setErrorDate(dateTime);
								int count1 =Integer.parseInt(errorBean.getErrorCount())+1;
								errorBean.setErrorCount(String.valueOf(count1));
								errorService.updateError(errorBean);
								error="密码错误,还有"+String.valueOf(5-count1)+"次机会";
								return error;
								//判断异常表中该用户登录异常的次数是否=4
							}else if(Integer.parseInt(errorBean.getErrorCount())==4){
								errorBean.setUserId(userId);
								String dateTime = DateUtil.getDateTime(new Date(),"");
								errorBean.setErrorDate(dateTime);
								int count3 =Integer.parseInt(errorBean.getErrorCount())+1;
								errorBean.setErrorCount(String.valueOf(count3));
								errorService.updateError(errorBean);
								error="密码错误,该用户已冻结,请在30分钟后重试！";
								return error;
							}else{
								String errorDate=errorBean.getErrorDate();
								String dateTime = DateUtil.getDateTime(new Date(),"");
								long dc=0;
								//把时间格式转换成字符格式
								String dt="";
								String[] a1 =dateTime.split("-");
								for(int n=0;n<a1.length;n++){
									dt=dt+a1[n];
								}
								String[] b1=dt.split(" ");
								dt="";
								for(int n=0;n<b1.length;n++){
									dt=dt+b1[n];
								}
								String[] c1=dt.split(":");
								dt="";
								for(int n=0;n<c1.length;n++){
									dt=dt+c1[n];
								}
								//把时间格式转换成字符格式
								String rD="";
								String[] a2 =errorDate.split("-");
								for(int n=0;n<a2.length;n++){
									rD=rD+a2[n];
								}
								String[] b2=rD.split(" ");
								rD="";
								for(int n=0;n<b2.length;n++){
									rD=rD+b2[n];
								}
								String[] c2=rD.split(":");
								rD="";
								for(int n=0;n<c2.length;n++){
									rD=rD+c2[n];
								}
								if(Long.parseLong(dt.substring(0, dt.length()-4))>Long.parseLong(rD.substring(0, rD.length()-4))){
									 dc=(Long.parseLong(dt)-4000-Long.parseLong(rD))/100;
								}else{
									 dc=(Long.parseLong(dt)-Long.parseLong(rD))/100;
								}
								
								//判断时候现在时间和该用户被锁定的时间是否>30分钟
								if(dc>30){
									errorBean.setUserId(userId);
									String dateTime2 = DateUtil.getDateTime(new Date(),"");
									errorBean.setErrorDate(dateTime2);
									errorBean.setErrorCount("5");
									errorService.updateError(errorBean);
									error="密码错误,请在30分钟后登陆";
									return error;
								}else{
								error="该用户已被冻结,"+String.valueOf(30-dc)+"分钟后可正常登录";
								return error;
								}
							}
						}else{
							ErrorBean errorB=new ErrorBean();
							errorB.setUserId(userId);
							String dateTime = DateUtil.getDateTime(new Date(),"");
							errorB.setErrorDate(dateTime);
							errorB.setErrorCount("1");
							errorService.insertError(errorB);
							error="密码错误,你还有4次机会";
							return error;
						}
					}
				}else{
					error="用户名不存在！";
				}
			}
		}else{
			error="用户名不能为空！";
		}
		
		return error;
		
	}
	
	@RequestMapping(value="/logout.do",method = RequestMethod.GET)
    public  String logout(UserBean userBean){
		super.session.invalidate();
		return "common/login";
	}
}
