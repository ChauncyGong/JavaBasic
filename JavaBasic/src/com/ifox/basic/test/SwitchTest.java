package com.ifox.basic.test;

public class SwitchTest {

	public static void main(String[] args) {
		String str = "aa";
		//long l = 110;                   // switch不支持long类型
		//Integer integer = new Integer(11);    //支持char,int,short,byte及其包装类型，另外枚举和字符串也支持
		switch (str) {
		case "aa":
			System.out.println("aa");
			break;
		case "bb": {
			System.out.println("bb");
		}
			
		default:
			break;
		}
	}
}
