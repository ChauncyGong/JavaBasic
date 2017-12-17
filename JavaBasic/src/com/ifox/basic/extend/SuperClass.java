package com.ifox.basic.extend;

/**
 * 证明多态性
 * @author Chauncy
 *
 */
public class SuperClass {
	
	public String name = "Supper.name";
	
	public static String staticVar = "Supper.staticVar";

	public static void doStaticWork() {
		System.out.println("Super.staticWork()");
	}
	
	public void dowork() {
		System.out.println("Super.work()");
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		SuperClass class1 = new SubClass();
		/**
		 * 【字段不具多态性】
		 */
		System.out.println("subObject.name = " + class1.name);
		/**
		 * 实际上编译后使用的类调用该方法，也即采用编译类型调用静态方法或变量
		 * 【所以静态域不具多态性】
		 */
		System.out.println("subObject.staticVar = " + class1.staticVar);
		
		/**
		 * 调用此方法时首先保证编译类型中存在该方法，否则编译报错
		 * 其次根据是否存在方法覆盖，确定调用实际类型的方法还是父类的方法
		 * 【静态方法不具多态性】
		 */
		class1.doStaticWork();
		
		class1.dowork();          //此处方法才是多态运行
	}
	
}

class SubClass extends SuperClass{
	
	public static String staticVar = "Sub.staticVar";
	
	public String name = "Sub.name";
	
	public static void doStaticWork() {
		System.out.println("Sub.staticWork");
	}
	
	public void dowork() {
		System.out.println("Sub work");
	}
}
