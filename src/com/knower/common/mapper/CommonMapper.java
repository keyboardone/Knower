package com.knower.common.mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @update by zsf
 *
 */
public interface CommonMapper {
	
    String selectMaxId(Map<String, String> tableInfo);
    
    /**
     * 根据表名，查询listObject列表
     * @param tableName
     * @return
     */
    
    List<Map<String,Object>> getDataByTableName(Map<String, String> tableNameInfo);

	
	
	
}