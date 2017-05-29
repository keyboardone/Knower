package com.knower.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.knower.common.mapper.CommonMapper;

/**
 * ID生产器
 * 
 * @author LT
 *
 */
@Repository
public class  IdGenerator{

	@Autowired
	private CommonMapper commonMapper;

	public final static int ID_COUNT = 8;
	
	public final static String ID_START = "0001";
    
	/**
	 * 根据表名和自动名自动生成自增ID
	 * 
	 * @param tableName 表名
	 * @param columnName 列名
	 * @param initial 首字母
	 * @return ID
	 */
	public String generateIdByTable(IdGeneratorEnum idEnum){
		
		Map<String,String> tableInfo = new HashMap<String,String>();
		tableInfo.put("tableName", idEnum.getTableName());
		tableInfo.put("columnName", idEnum.getColumnName());
		tableInfo.put("initial", idEnum.getInitial());
		tableInfo.put("resType", idEnum.getInitial());
		
		// 获取当前编号最大值
		String result = commonMapper.selectMaxId(tableInfo);
		
		// 新ID
		StringBuffer newId = new StringBuffer();
		// 如果返回结果不为空
		if(StringUtils.isNotEmpty(result)){
			int id = Integer.parseInt(result.substring(4));
			id =id +1;
			
			newId.append(idEnum.getInitial());
			// 获取补零的长度
			int cnt=ID_COUNT-String.valueOf(id).length();
			while(newId.toString().length()!=cnt){
				newId.append("0");
			}
			newId.append(String.valueOf(id));
		}else{
			newId.append(idEnum.getInitial());
			newId.append("000");
			newId.append(ID_START);
		}
		
		return newId.toString();
	}
	

}
