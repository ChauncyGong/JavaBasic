package com.ifox.collection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class PropertiesDemo {
	
	@Test
	public void testProperties() {
		Properties properties = new Properties();
		properties.put("driverClass", "com.jdbc.mysql.Driver");
		properties.put("userName", "root");
		properties.put("password", "admin");
		properties.put("url", "jdbc.mysql://localhost:3306/demo");
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	@Test
	public void testProperties2() throws IOException {
		Properties properties = new Properties();
		/**
		 * 两种获取ClassLoader的方式加载配置文件
		 * 1.Thread.currentThread().getContextClassLoader;
		 * 2.getClass.getClassLoader();
		 */
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties");
//		InputStream in = getClass().getClassLoader()
//				.getResourceAsStream("db.properties");
		properties.load(in);
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
