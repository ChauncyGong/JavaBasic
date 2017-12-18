package com.ifox.basic.grammer;

import org.junit.Test;

public class NumberTest {
	
	@Test
	public void showRange() {
		System.out.println("byte:" + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("char:" + Character.MIN_VALUE + " ~ " + Character.MAX_VALUE);
		System.out.println("short:" + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int:" + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long:" + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		System.out.println("float:" + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double:" + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		System.out.println("自动类型转换：byte -> short -> int -> long -> float ->double");
	}
	
	@Test
	public void ByteTest() {
		byte b = 127;			//字面隐式类型转换为short
		System.out.println(b);
		b = (byte) 128;			//当字面量数值超过其类型可表示的范围时，必须强制转化为byte
		/**
		 * 	127		(补码): 0111 1111
		 *  127+1	(补码): 1000 0000
		 *  		(反码): 1111 1111
		 *  		(原码): 1000 0000
		 *  = -128
		 */
		System.out.println(b);
	}
	
	@Test
	public void charTest() {

		/*
		 * char的三种表示方式
		 */
		char c = 'A';
		System.out.println(c);
		c = 65;
		System.out.println(c);
		c = '\u0041';
		System.out.println(c);
		byte b = 10;
		c = (char) b;			//char不能和其他类型自动类型转换，都需强转，因为表示数的范围不兼容
	}
	
	@Test 
	public void shortTest() {
		short s = 10;
		System.out.println(s);
	}
	
	@Test
	public void intTest() {
		int i = 0b11;			// 0b或0B: 2进制
		System.out.println(i);
		i = 011;				// 0: 8进制
		System.out.println(i);
		i = 11;					// 10进制,整数字面量默认为int类型
		System.out.println(i);
		i = 0x11;				// 0x或0X: 16进制
		System.out.println(i);
	}
	
	@Test
	public void longTest() {
		long l = 10;		//int自动类型转换为long
		l = 10L;			//直接赋值long类型,用l或L表示
		System.out.println(l);
	}	
	
	@Test
	public void floatTest() {
		float f = 100L;		//long自动类型转换为float
		f = 3.14f;			//float类型数值用f或F表示
		f = .55f;			//小于1的小数可不写0.
		f = 3.14e2f;		//科学计数法
		f = (float) 3.14;	//小数字面量默认为double类型，需强制转换为float
		System.out.println(f);
	}
	
	@Test
	public void doubleTest() {
		double d = 100f;	//float自动类型转化为double
		d = 3.14d;			//double类型用小数字面量或d或D表示
		System.out.println(d);
	}
	
	@Test
	public void shifting() {		//移位操作，讨论正负两种情况
		int o = 10;
		System.out.println(o>>2);
		System.out.println(o>>>2);		//可见正数(有无)符号右移几位表示执行/2操作几次
		System.out.println(o<<2);		//有符号左移几位表示执行*2操作几次
		
		int i = -200;
		/**
		 * 10000000 00000000 00000000 11001000	原
		 * 11111111 11111111 11111111 00110111	反
		 * 11111111 11111111 11111111 00111000	补
		 * :>>1
		 * 11111111 11111111 11111111 10011100
		 * 11111111 11111111 11111111 10011011
		 * 10000000 00000000 00000000 01100100	->-100
		 * :<<1
		 * 11111111 11111111 11111110 01110000
		 * 11111111 11111111 11111110 01101111
		 * 10000000 00000000 00000001 10010000	->-400
		 * :>>>2
		 * 00111111 11111111 11111111 11001110	补
		 * 00111111 11111111 11111111 11001101	反
		 * 01000000 00000000 00000000 00110010	原->
		 */
		System.out.println("-200:"+Integer.toBinaryString(i));    //Integer.toBinaryString输出补码
		System.out.println("-200>>>2 = " + (i>>>2));
		System.out.println("-200>>>2:"+Integer.toBinaryString(i>>>2));
		/**
		 * 此处发现0B表示数值是数的二进制补码形式
		 */
		System.out.println(0B11111111_11111111_11111111_00111000);
		System.out.println(0B00111111_11111111_11111111_11001110);
	}
	
	@Test
	public void logic() {
		/**
		 * 		00000000_00000000_00000000_00000001
		 * ~:补	11111111_11111111_11111111_11111110
		 * 	反	11111111_11111111_11111111_11111101
		 * 	原	10000000_00000000_00000000_00000010
		 */
		System.out.println(~1);
		/**
		 * 	原	1000_0001
		 * 	反	1111_1110
		 * 	补	1111_1111
		 * 	补	0000_0010
		 * 	结果	1111_1101
		 * 	反	1111_1100
		 * 	原	1000_0011	：-3
		 */
		System.out.println(-1^2);		//相同为0，不同为1
		System.out.println(0b10000000_00000000_00000000_00000000);
	}
	
	@Test
	public void exchange() {			//交换两个变量，不使用第三个值
		int a = 10, b = 15;
		a = b - a;
		b = b - a;
		a = a + b;
		System.out.println(a + "   " + b);
	}
}
