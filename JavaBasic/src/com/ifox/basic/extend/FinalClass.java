package com.ifox.basic.extend;

/**
 * 使用final关键字
 * @author Chauncy
 *
 */
public class FinalClass {
	
	public static final int a;           //全局静态常量
	
	static {
		a = 20;							//常量必须制定初始值
	}
	
	public final void print(final int x) {
		System.out.println("final");
//		x = 10;                           //final修饰的局部变量值不能被修改
	}

	public static void main(String[] args) {
		System.out.println(FinalClass.a);
		System.out.println(SonClass.a);
		new SonClass().print(0);
	}
}

class SonClass extends FinalClass{
	
//	public void print(int x) {				//final方法不能被复写
//		System.out.println("print");
//	}
	
}
