package com.ifox.common;

import org.junit.Test;

public class Demo {
	
	@SuppressWarnings("unused")
	public String testNull1() {
		return 1 > 2 ? "abc" : null;
	}
	
	@SuppressWarnings({"unused" })
	public int testNull2() {
		return (1 > 2 ? null : 0);
	}
	
	/**
	 * 测试返回null
	 */
	@Test
	public void test1() {
		
		System.out.println(testNull1());			//引用数据类型：返回null
//		System.out.println(testNull2());			//基本数据类型：NullPointerException
//		System.out.println(new String(null));		//编译报错
//		System.out.println(new Integer(null));		//NumberFormatException
	}
	
	
	@SafeVarargs
	public static <T> void func(T... a) {
		System.out.println(a.length);
		for (T t : a) {
			System.out.println(t.getClass());
		}
	}
	
	/**
	 * 测试可变参数类型
	 */
	@Test
	public void test2() {
		func("aa",10,11.11);
	}
	
}

