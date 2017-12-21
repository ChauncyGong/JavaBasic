package com.ifox.common;

public class Demo {
	
	public static String func() {
		return 5 > 7 ? "null" : null;
	}
	
	public static <T> String func(T... a) {
		System.out.println(a.length);
		for (T t : a) {
			System.out.println(t.getClass());
		}
		return "0";
	}
	
	public static void main(String[] args) {
		System.out.println(func("aa",10,11.11));
	}
}
