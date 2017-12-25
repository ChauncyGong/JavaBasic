package com.ifox.basic.extend;

/**
 * 匿名内部类
 * @author Chauncy
 *
 */
public abstract class AbstractClass {
	
	public AbstractClass(String str){			//抽象类有构造器，但是不能new对象创建实例
		System.out.println(str);				//仅用于子类创建实例时调用父类构造器
	}
	
	abstract void print();

	public static void main(String[] args) {
		new AbstractClass("11") {              //匿名内部类，此处会调用父类构造器
			
			{
				System.out.println("111");    //匿名内部类没有构造器，但可以定义初始化块
			}
			@Override
			public void print() {			//实现抽象类的抽象方法或实现接口
				System.out.println("222");
			}
			
		}.print();
	}
}
