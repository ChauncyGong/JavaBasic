package com.ifox.basic.grammer;

import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "package com.ifox.basic.test;\r\n" + 
				"\r\n" + 
				"import java.util.ArrayList;\r\n" + 
				"import java.util.Arrays;\r\n" + 
				"import java.util.List;\r\n" + 
				"\r\n" + 
				"import org.junit.Test;\r\n" + 
				"\r\n" + 
				"public class ArrayTest {\r\n" + 
				"	\r\n" + 
				"	@Test\r\n" + 
				"	public void testArray() {\r\n" + 
				"		int[] ints1 = new int[5];		//��������ʼ������ʹ�ã��������ڴ�ռ�,ֵΪ�����͵�Ĭ��ֵ(0)\r\n" + 
				"		int[] ints2 = new int[] {1, 2};		//��̬��ʼ����ϵͳ�Զ��ж������С\r\n" + 
				"		int[] ints3 = {1, 2, 3};		//��ʽ2�ļ���д��\r\n" + 
				"		System.out.println(ints1.getClass().getSimpleName());\r\n" + 
				"		System.out.println(ints1.length);        //5\r\n" + 
				"		for (int i : ints1) {\r\n" + 
				"			System.out.println(i);\r\n" + 
				"		}\r\n" + 
				"		System.out.println(ints2.length);		//2\r\n" + 
				"		System.out.println(ints3.length);		//3\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	@Test\r\n" + 
				"	public void testListToArray() {\r\n" + 
				"		List<String> list = new ArrayList<>();\r\n" + 
				"		for(int i =0; i < 10; i++) {\r\n" + 
				"			list.add(\"\" + i);\r\n" + 
				"		}\r\n" + 
				"		for (Object object : list) {\r\n" + 
				"			System.out.println(object);\r\n" + 
				"		}\r\n" + 
				"		/**\r\n" + 
				"		 * �˴�ֱ��ת���������\r\n" + 
				"		 * java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String\r\n" + 
				"		 * object ����ת��Ϊ string  ����ת�͵�����\r\n" + 
				"		 */\r\n" + 
				"		//String[] strs = (String[]) list.toArray();\r\n" + 
				"		/**\r\n" + 
				"		 * ����취���������·�ʽ\r\n" + 
				"		 */\r\n" + 
				"		String[] strs = new String[list.size()];\r\n" + 
				"		strs = list.toArray(strs);\r\n" + 
				"		System.out.println(Arrays.toString(strs));\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	@Test\r\n" + 
				"	public void testArrayToList() {\r\n" + 
				"		\r\n" + 
				"//		String[] objs = new String[] {\"11\",\"22\"};\r\n" + 
				"//		int[] objs = new int[] {1, 2, 3};\r\n" + 
				"		Integer[] objs = new Integer[] {new Integer(1), new Integer(2)};\r\n" + 
				"		/**\r\n" + 
				"		 * �˴�List<T> Arrays.asList(T ...)���ܴ��� int[]�Ȼ����������飬 ���ܴ����������\r\n" + 
				"		 */\r\n" + 
				"//		List<String> list = Arrays.asList(objs);\r\n" + 
				"//		List<int> list = Arrays.asList(objs);   //��ΪList<int>����д���Ǵ���ģ�Listֻ�ܳ��ж���\r\n" + 
				"		List<Integer> list = Arrays.asList(objs);\r\n" + 
				"		for (Integer obj : list) {\r\n" + 
				"			System.out.println(obj);\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"}\r\n" + 
				"";
		byte[] bs = str.getBytes("UTF-8");
		str = new String(bs, "ASCII");
		System.out.println(str);
	}
}
