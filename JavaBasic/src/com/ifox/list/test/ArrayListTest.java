package com.ifox.list.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	/**
	 * 删除List中元素测试，使用ArrayList
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void removeListTest() {
		//List<Integer> integers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
		/**
		 * 抛出异常java.lang.UnsupportedOperationException
		 */
		//integers.remove(new Integer(1));
		List<Integer> integers = new ArrayList<>();
		
		integers.add(new Integer(2));
		integers.add(new Integer(1));
		integers.add(new Integer(3));
		
		/**
		 * 查看源码可知此处通过equals方法比较删除相等的对象，而不一定删除的一定是同一个对象
		 */
		//integers.remove(new Integer(1));
		/**
		 * 发现此处是指删除位置为2的元素，并没有进行自动类型转换
		 */
		integers.remove(2);			//输出 2 3
		for (Integer integer : integers) {
			System.out.println(integer);
		}
		
		System.out.println("------我是分割线---------");
		
		List<String> strings = new ArrayList<>();
		strings.add(new Integer(2).toString());
		strings.add(new Integer(1).toString());
		strings.add(new Integer(3).toString());
		/**
		 * 发现此处并没有发生支佛那个类型转换而调用remove(int x): 此方法返回指定位置删除的元素
		 * 而是调用了remove(object o)的方法 	:此方法返回是否删除boolean				
		 */
		strings.remove(new Integer(2));
		for (String string : strings) {
			System.out.println(string);   //输出 2 1 3
		}
	}
}
