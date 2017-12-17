package com.ifox.basic.grammer;

import org.junit.Test;

/**
 * ѭ��������
 * @author Chauncy
 *
 */
public class LoopTest {
	
	//���������
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
	
	//����žų˷���
	@Test
	public void printMultTable() {
		int i, j;
		outer:for (i = 1; i < 10; i++) {         //����ѭ����־
			for (j = 1; j <= i; j++) {
				if(i == 6) {
					break outer;             //�ڲ�ѭ���н������ѭ��
				}
				System.out.print(j + "*" + i + "=" + i * j + "	");
				
			}
			System.out.println();
		}
	}
	
	//�����ַ���
	@Test
	public void ergodicString() {
		String str = "abcdefg";
		for (char c : str.toCharArray()) {
			System.out.println(c);
			
		}
	}
}
