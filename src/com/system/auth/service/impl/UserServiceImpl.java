package com.system.auth.service.impl;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knower.common.util.DateUtil;
import com.system.auth.bean.UserBean;
import com.system.auth.dao.UBaseUserDao;
import com.system.auth.service.UserService;
import com.system.common.Constants;
import com.system.common.entity.UBaseUser;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
	private UBaseUserDao uBaseUserDao;
    @Autowired  
	private HttpSession session;
	@Override
	public UserBean findUserById(String userId) {
		UserBean result = new UserBean();
		UBaseUser baseUser  = uBaseUserDao.selectByPrimaryKey(userId);
		if(baseUser == null){
			return null;
		}
		BeanUtils.copyProperties(baseUser, result);
		return result;
	}

	//任冰 查询所有用户
    public List<UBaseUser> loadUserData(){
    	List<UBaseUser> list = uBaseUserDao.loadUserData();
    	return list;
    }
    
	// 任冰 新增用户
	@Override
	public int insert(UBaseUser record) {
		String userId = record.getUserEname();
		record.setUserId(userId);
		uBaseUserDao.insert(record);
		return 0;
	}
	
	// 任冰 删除用户
	@Override
	public void deleteUser(String userId){
		uBaseUserDao.deleteUser(userId);
	}
	
	// 任冰 修改用户
	@Override
	public void updateUser(UBaseUser record){
		uBaseUserDao.updateUser(record);
	}
}
