package com.ifox.interview;

/**
 * 考察创建类时类加载执行顺序
 * @author Chauncy
 *
 */
public class App {

	public static App app = new App();
	public SuperClass spClass = new SubClass();
	
	static {
		System.out.println("1");
	}
	
	public App() {
		System.out.println("2");
	}
	
	public static void main(String[] args) {
		System.out.println("3");
	}
	
}

class SuperClass {
	
	public SuperClass() {
		System.out.println("4");
	}
}

class SubClass extends SuperClass {
	
	static {
		System.out.println("5");
	}
	
	public SubClass() {
		System.out.println("6");
	}
}