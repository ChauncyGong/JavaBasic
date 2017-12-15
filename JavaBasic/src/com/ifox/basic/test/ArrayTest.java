package com.ifox.basic.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayTest {
	
	@Test
	public void testArray() {
		int[] ints1 = new int[5];		//��������ʼ������ʹ�ã��������ڴ�ռ�,ֵΪ�����͵�Ĭ��ֵ(0)
		int[] ints2 = new int[] {1, 2};		//��̬��ʼ����ϵͳ�Զ��ж������С
		int[] ints3 = {1, 2, 3};		//��ʽ2�ļ���д��
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
		 * �˴�ֱ��ת���������
		 * java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String
		 * object ����ת��Ϊ string  ����ת�͵�����
		 */
		//String[] strs = (String[]) list.toArray();
		/**
		 * ����취���������·�ʽ
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
		 * �˴�List<T> Arrays.asList(T ...)���ܴ��� int[]�Ȼ����������飬 ���ܴ����������
		 */
//		List<String> list = Arrays.asList(objs);
//		List<int> list = Arrays.asList(objs);   //��ΪList<int>����д���Ǵ���ģ�Listֻ�ܳ��ж���
		List<Integer> list = Arrays.asList(objs);
		for (Integer obj : list) {
			System.out.println(obj);
		}
	}
	
}
