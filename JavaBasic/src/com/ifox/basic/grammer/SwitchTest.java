package com.ifox.basic.grammer;

public class SwitchTest {

	public static void main(String[] args) {
		String str = "aa";
		//long l = 110;                   // switch��֧��long����
		//Integer integer = new Integer(11);    //֧��char,int,short,byte�����װ���ͣ�����ö�ٺ��ַ���Ҳ֧��
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
