package com.ifox.basic._enum;

import java.util.Arrays;

/**
 * 使用enum枚举定义一个枚举类
 * enum和普通类一样，可以定义字段，方法，构造器;
 * 前提是在类开始处定义一个或多个实例;
 * 唯一不同的是，其只能实现，不能继承类，
 * 因为其底层就是一个类继承了java.lang.Enum类，并创建了枚举实例对象
 * @author Chauncy
 *
 */
public enum Gender implements EnumDesc{
//	MALE, FAMALE;
	
	MALE("男"){			//这里类似于匿名内部类，创建的实例对象需要实现接口中的方法
		@Override
		public void info() {
			System.out.println("nan");
		}
	},FEMALE("女"){
		@Override
		public void info() {
			System.out.println("nv");
		}
	};
	
	private String name;
	
	private Gender(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("....");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Gender gender  = Gender.MALE;
		gender.info();
		System.out.println(gender.name());
		System.out.println(gender.ordinal());
		System.out.println(Arrays.toString(Gender.values()));
		System.out.println(Enum.valueOf(Gender.class, "MALE"));
	}
	
}

