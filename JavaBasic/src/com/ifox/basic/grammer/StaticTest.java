package com.ifox.basic.grammer;

public class StaticTest {
	
	public static String type = "static";
	
	{
		System.out.println("赋值 i = 10");
		i = 10;
	}
	
	public int i = 5;
	
	public StaticTest() {
		System.out.println("构造前 i = " + i);
		i = 15;
		System.out.println("构造后 i = " + i);
	}
	
	public static void print() {
		System.out.println("static print");
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
        /**
         * 编译时，字段赋值操作和初始化块都放在 构造器代码之前，至于谁先执行，取决于他们的相对位置
         */
		StaticTest s = new StaticTest(); 
		System.out.println(s.type);
		
		/**
		 * 该类的null对象可以访问该类的静态成员,但不能直接使用 null.方法
		 */
		s = null;
		s.print();
	}
}
