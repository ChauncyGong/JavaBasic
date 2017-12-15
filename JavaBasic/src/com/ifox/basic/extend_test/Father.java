package com.ifox.basic.extend_test;

public class Father {
	
	
	static{
		System.out.println("Father static");
		static_var = "123";
	}
	protected static String static_var = "111";
	
	private int i;
	
	{
		System.out.println("Father init...");
	}
	
	public Father() {
		// TODO Auto-generated constructor stub
		System.out.println("Father 无参构造器");
	}
	
	public Father(int i) {
		System.out.println("Father 带参构造器");
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	
	public Father doWork() {
		System.out.println("father work");
		return this;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println("name = " + new Son().static_var);
//		String str = new Son(1,5).doWork().toString();
//		System.out.println(str);
	}
}

class Son extends Father{
	
	static {
		System.out.println("Son static");
	}
	
	private int i;
	
	private int j;
	
	{
		System.out.println("Son init...");
	}
	
	public Son() {
		System.out.println("Son 无参构造器");
	}
	
	public Son (int i, int j) {
		super(10);
		System.out.println("Son 带参数构造器");
		this.i = i;
		this.j = j;
	}
	
	@Override
	public String toString() {
		int i =0;
		System.out.println(i);
		System.out.println(this.i);
		System.out.println(super.getI());
		return "i = "+ i + ", j = " + j; 
	}
}