package com.knower.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王利江
 * @date 2017-05-02
 */
public final class CollectionsUtil {
	/**
	 * 将map中的key中的大写字母全部转换为小写字母
	 * */
	public static Map<String, String> convertKeyToLower(Map<String, Object> map){
		Map<String, String> m = new HashMap<String, String>();
		if(!isEmptyMap(map)){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				m.put(entry.getKey(), StringUtils.convertObjToStr(entry.getValue()));
			}
		}
		return m;
	}
	
	/**
	 * 将map中的key中的大写字母全部转换为小写字母
	 * */
	public static List<Map<String, String>> convertKeyToLower(List<Map<String, Object>> list){
		List<Map<String, String>>  dataList = new ArrayList<Map<String,String>>();
		if(!isEmptyCollection(list)){
			for (Map<String, Object> map : list) {
				dataList.add(convertKeyToLower(map));
			}
		}
		return dataList;
	}
	
	/**
	 * 判断集合是否为空
	 * @param coll 集合元素
	 * @return true-空，false-非空
	 * */
	public static boolean isEmptyMap(Map<String, ? extends Object> map){
		return !(map !=null && !map.isEmpty());
	}
	
	/**
	 * 判断集合是否为空
	 * @param coll 集合元素
	 * @return true-空，false-非空
	 * */
	public static boolean isEmptyCollection(Collection<?> coll){
		return !(coll !=null && !coll.isEmpty());
	}
}
