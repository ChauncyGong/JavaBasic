package com.ifox.basic.test;

import org.junit.Test;

/**
 * 循环语句测试
 * @author Chauncy
 *
 */
public class LoopTest {
	
	//输出三角形
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
	
	//输出九九乘法表
	@Test
	public void printMultTable() {
		int i, j;
		outer:for (i = 1; i < 10; i++) {         //设置循环标志
			for (j = 1; j <= i; j++) {
				if(i == 6) {
					break outer;             //内层循环中结束外层循环
				}
				System.out.print(j + "*" + i + "=" + i * j + "	");
				
			}
			System.out.println();
		}
	}
	
	//遍历字符串
	@Test
	public void ergodicString() {
		String str = "abcdefg";
		for (char c : str.toCharArray()) {
			System.out.println(c);
			
		}
	}
}
