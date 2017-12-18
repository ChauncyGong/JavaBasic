package com.ifox.basic.grammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayTest {
	
	@Test
	public void testArray() {
		/**
		 * 三种初始化方式
		 */
		int[] ints1 = new int[5];		//动态初始化
		int[] ints2 = new int[] {1, 2};		//静态初始化
		int[] ints3 = {1, 2, 3};		//同上
		System.out.println(ints1.getClass().getSimpleName());
		System.out.println(ints1.length);        //5
		System.out.println(ints2.length);		//2
		System.out.println(ints3.length);		//3
		
	}
	
	@Test
	public void listToArray() {
		List<String> list = new ArrayList<>();
		for(int i =0; i < 10; i++) {
			list.add("" + i);
		}
		/**
		 * java.lang.ClassCastException: Object[] cannot be cast to String[]
		 */
//		String[] strs = (String[]) list.toArray();	//返回类型是Object[]，不能转化为String[]
		/**
		 * 采用如下方式
		 */
		String[] strs = new String[list.size()];
		strs = list.toArray(strs);
		System.out.println(Arrays.toString(strs));
	}
	
	@Test
	public void arrayToList() {
		
//		int[] ints = new int[] {1, 2, 3};
		Integer[] objs = new Integer[] {new Integer(1), new Integer(2)};
		String[] strings = new String[] {"11","22"};
		/**
		 * 	List<T> Arrays.asList(T ...) 可以传递对象数组转化为List
		 */
//		List<int> list = Arrays.asList(ints);
		List<Integer> list1 = Arrays.asList(objs);
		List<String> list2 = Arrays.asList(strings);
		for (Integer obj : list1) {
			System.out.println(obj);
		}
		for (String obj : list2) {
			System.out.println(obj);
		}
	}
	
}
