package com.system.common.mapper;

import java.util.List;

import com.system.error.bean.ErrorBean;

public interface ErrorMapper {
	
	List<ErrorBean> selectErrorlist();
	
	ErrorBean selectErrorByUserId(String userId);
	
	void insertError(ErrorBean errorBean);
	
	void updateError(ErrorBean errorBean);
    
	void deleteError(String userId);
}