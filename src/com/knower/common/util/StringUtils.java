package com.knower.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王利江
 * @date 2017-05-02
 */
public final class StringUtils {
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String str){
		if(str != null && str.trim().length() > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 将字符串转换成小写
	 * */
	public static String toLower(String str){
		if(isNotEmpty(str)){
			return str.trim().toLowerCase();
		}
		return "";
	}
	
	/**
	 * 将obj转换成string
	 * */
	public static String convertObjToStr(Object obj){
		if(obj != null){
			return obj.toString().trim();
		}
		return "";
	}
//	public static void main(String[] args) {
//		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
//		Map<String, String> map = new HashMap<String, String>();
//		list.add(map);
//		list.add(map);
//		System.out.println(list.size());
//	}
	
}