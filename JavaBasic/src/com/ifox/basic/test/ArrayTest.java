package com.ifox.basic.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayTest {
	
	@Test
	public void testArray() {
		int[] ints1 = new int[5];		//数组必须初始化才能使用，即分配内存空间,值为该类型的默认值(0)
		int[] ints2 = new int[] {1, 2};		//静态初始化：系统自动判断数组大小
		int[] ints3 = {1, 2, 3};		//方式2的简略写法
		System.out.println(ints1.getClass().getSimpleName());
		System.out.println(ints1.length);        //5
		for (int i : ints1) {
			System.out.println(i);
		}
		System.out.println(ints2.length);		//2
		System.out.println(ints3.length);		//3
		
	}
	
	@Test
	public void testListToArray() {
		List<String> list = new ArrayList<>();
		for(int i =0; i < 10; i++) {
			list.add("" + i);
		}
		for (Object object : list) {
			System.out.println(object);
		}
		/**
		 * 此处直接转化会出问题
		 * java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String
		 * object 不能转化为 string  向下转型的问题
		 */
		//String[] strs = (String[]) list.toArray();
		/**
		 * 解决办法：采用如下方式
		 */
		String[] strs = new String[list.size()];
		strs = list.toArray(strs);
		System.out.println(Arrays.toString(strs));
	}
	
	@Test
	public void testArrayToList() {
		
//		String[] objs = new String[] {"11","22"};
//		int[] objs = new int[] {1, 2, 3};
		Integer[] objs = new Integer[] {new Integer(1), new Integer(2)};
		/**
		 * 此处List<T> Arrays.asList(T ...)不能处理 int[]等基本类型数组， 但能处理对象数组
		 */
//		List<String> list = Arrays.asList(objs);
//		List<int> list = Arrays.asList(objs);   //因为List<int>这种写法是错误的，List只能持有对象
		List<Integer> list = Arrays.asList(objs);
		for (Integer obj : list) {
			System.out.println(obj);
		}
	}
	
}
