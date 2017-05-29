package com.system.error.service;

import java.util.List;

import com.system.error.bean.ErrorBean;

public interface ErrorService {
	public List<ErrorBean> selectErrorlist();
	
	public ErrorBean selectErrorByUserId(String userId);
	
	public void insertError(ErrorBean errorBean);

	public void updateError(ErrorBean errorBean);

	public void deleteError(String userId);
}
