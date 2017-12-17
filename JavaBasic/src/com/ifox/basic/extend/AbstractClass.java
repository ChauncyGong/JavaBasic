package com.ifox.basic.extend;

/**
 * 匿名内部类
 * @author Chauncy
 *
 */
public abstract class AbstractClass {
	
	abstract void print();

	public static void main(String[] args) {
		new AbstractClass() {              //匿名内部类
			
			{
				System.out.println("111");    //虽然没有构造器，但可以定义初始化块
			}
			@Override
			public void print() {			//实现抽象类的抽象方法或实现接口
				System.out.println("222");
			}
			
		}.print();
	}
}
