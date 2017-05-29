package com.system.error.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.system.common.mapper.ErrorMapper;
import com.system.error.bean.ErrorBean;
import com.system.error.dao.ErrorDao;

@Repository
public class ErrorDaoImpl implements ErrorDao {
	   @Autowired
	   private ErrorMapper errorMapper;

	@Override
	public List<ErrorBean> selectErrorlist() {
		return errorMapper.selectErrorlist();
	}

	@Override
	public void insertError(ErrorBean errorBean) {
		errorMapper.insertError(errorBean);
	}

	@Override
	public void updateError(ErrorBean errorBean) {
		errorMapper.updateError(errorBean);
	}

	@Override
	public void deleteError(String userId) {
		errorMapper.deleteError(userId);
	}

	@Override
	public ErrorBean selectErrorByUserId(String userId) {
		return errorMapper.selectErrorByUserId(userId);
	}

	   
}
