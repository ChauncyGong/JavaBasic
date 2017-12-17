package com.ifox.basic.extend;

/**
 * 证明方法重载时多态运行结果
 * @author Chauncy
 *
 */
public class BaseClass {
	public static void work(BaseClass bc) {
		System.out.println("base");
	}

	public static void work(SmallClass sc) {
		System.out.println("small");
	}

	public static void main(String[] args) {
		BaseClass bc = new SmallClass();
		BaseClass.work(bc); //此处虽然存在多态，但在重载中是根据静态编译类型确定调用方法，即重载不具多态性
	}

}

class SmallClass extends BaseClass {

}