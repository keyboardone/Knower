package com.system.error.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knower.common.util.DateUtil;
import com.system.error.bean.ErrorBean;
import com.system.error.dao.ErrorDao;
import com.system.error.service.ErrorService;
@Service
public class ErrorServiceImpl implements ErrorService {
    @Autowired
	private ErrorDao errorDao;

	@Override
	public List<ErrorBean> selectErrorlist() {
		return errorDao.selectErrorlist();
	}

	@Override
	public void insertError(ErrorBean errorBean) {
		errorDao.insertError(errorBean);
	}

	@Override
	public void updateError(ErrorBean errorBean) {
		errorDao.updateError(errorBean);
	}

	@Override
	public void deleteError(String userId) {
		errorDao.deleteError(userId);
	}

	@Override
	public ErrorBean selectErrorByUserId(String userId) {
		return errorDao.selectErrorByUserId(userId);
	}
   
	

}
