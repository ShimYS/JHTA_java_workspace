package com.sample.bookstore.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QueryUtil {
	
	//query.properties�� ���ǵ� ������ key, value�� ������ �����ϴ� ��ü
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(new FileInputStream("src/com/sample/bookstore/dao/query.properties"));
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ������ �̸��� �������� ��ȯ�Ѵ�.
	 * @param name query.properties�� ���ǵ� SQL�� �̸�
	 * @return SQL ����, ��ȿ�� �̸��� �ƴ� ��� null�� ��ȯ��
	 */
	public static String getSQL(String name) {
		return prop.getProperty(name);
	}
}
