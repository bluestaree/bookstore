package com.store.utils;

import java.util.UUID;

/**
 * ��������ַ���������
 * @author dhw
 *
 */
public class UUIDUtils {
	
	//�������ַ���
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
