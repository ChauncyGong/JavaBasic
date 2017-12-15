package com.ifox.basic.extend_test;

public class SuperClass {
	
	public static String var = "Supper";

	public static void dowork() {
		System.out.println("Super work");
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		SuperClass class1 = new SubClass();
		/**
		 * 实际上编译后使用的类调用该方法，也即采用编译类型调用静态方法或变量
		 * 所以静态域不具多态性
		 */
		class1.dowork();
		System.out.println();
		/**
		 * 调用此方法时首先保证编译类型中存在该方法，否则编译报错
		 * 其次根据是否存在方法覆盖，确定调用实际类型的方法还是父类的方法
		 */
		class1.dowork();
	}
	
}

class SubClass extends SuperClass{
	
	public static String var = "Sub";
	
	public static void dowork() {
		System.out.println("Sub work");
	}
}
