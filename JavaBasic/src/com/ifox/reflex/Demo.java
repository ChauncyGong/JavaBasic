package com.ifox.reflex;

import java.lang.reflect.Constructor;

enum Gender{
	INSTANCE;
}

public class Demo {

	public static void main(String[] args) {
		Class<Gender> clz = Gender.class;
		System.out.println(clz);
		Constructor<?>[] constructors = clz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		System.out.println("没有构造器？");
	}
}

