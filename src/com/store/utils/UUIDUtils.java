package com.store.utils;

import java.util.UUID;

/**
 * 生成随机字符串工具类
 * @author dhw
 *
 */
public class UUIDUtils {
	
	//获得随机字符串
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
