package com.ifox.basic.grammer;

import org.junit.Test;

/**
 * @author Chauncy
 *
 */
public class ControlTest {
	
	public void SwitchTest() {
		String str = "AA";
		//long l = 110;
		//Integer integer = 11;
		/**
		 * 	switch支持byte, char, short, int及其包装类型和String, enum
		 */
		switch (str) {
		case "AA":							//switch后只能跟常量	
			System.out.println("AA");
			break;
		case "BB": {
			System.out.println("BB");
		}
			
		default:
			break;
		}
	}
	
	@Test
	public void printTriangle() {
		int i, j, k;
		for(i = 0; i < 5; i++) {
			for(j = 5; j - i > 0 ; j-- ) {
				System.out.print(" ");
			}
			for (k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void printMultTable() {
		int i, j;
		outer:for (i = 1; i < 10; i++) {			//可以指定loop标签
			inner:for (j = 1; j <= i; j++) {
				if(i == 6) {
					break outer;					//终止外层循环
				}
				System.out.print(j + "*" + i + "=" + i * j + "	");
				
			}
		}
		System.out.println();
	}
	
	@Test
	public void ergodicString() {
		String str = "abcdefg";
		for (char c : str.toCharArray()) {
			System.out.println(c);
		}
	}
}
