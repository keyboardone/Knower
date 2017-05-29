package com.knower.common.util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.knower.common.mapper.CommonMapper;
@Repository
public class UUIDGenerator {
	@Autowired
	private CommonMapper commonMapper;
	public UUIDGenerator() { 
    } 
    /** 
     * 获得一个UUID 
     * 用法：
     * String userId = UUIDGenerator.getUUID();
	 * record.setUserId(userId);
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        s = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        return s; 
    } 
    
}
