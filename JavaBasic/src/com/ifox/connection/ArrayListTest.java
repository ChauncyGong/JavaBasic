package com.ifox.connection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	/**
	 * ɾ��List��Ԫ�ز��ԣ�ʹ��ArrayList
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void removeListTest() {
		//List<Integer> integers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
		/**
		 * �׳��쳣java.lang.UnsupportedOperationException
		 */
		//integers.remove(new Integer(1));
		List<Integer> integers = new ArrayList<>();
		
		integers.add(new Integer(2));
		integers.add(new Integer(1));
		integers.add(new Integer(3));
		
		/**
		 * �鿴Դ���֪�˴�ͨ��equals�����Ƚ�ɾ����ȵĶ��󣬶���һ��ɾ����һ����ͬһ������
		 */
		//integers.remove(new Integer(1));
		/**
		 * ���ִ˴���ָɾ��λ��Ϊ2��Ԫ�أ���û�н����Զ�����ת��
		 */
		integers.remove(2);			//��� 2 3
		for (Integer integer : integers) {
			System.out.println(integer);
		}
		
		System.out.println("------���Ƿָ���---------");
		
		List<String> strings = new ArrayList<>();
		strings.add(new Integer(2).toString());
		strings.add(new Integer(1).toString());
		strings.add(new Integer(3).toString());
		/**
		 * ���ִ˴���û�з���֧���Ǹ�����ת��������remove(int x): �˷�������ָ��λ��ɾ����Ԫ��
		 * ���ǵ�����remove(object o)�ķ��� 	:�˷��������Ƿ�ɾ��boolean				
		 */
		strings.remove(new Integer(2));
		for (String string : strings) {
			System.out.println(string);   //��� 2 1 3
		}
	}
}
