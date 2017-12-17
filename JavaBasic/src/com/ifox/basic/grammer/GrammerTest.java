package com.ifox.basic.grammer;

import org.junit.Test;

/**
 * �����﷨����
 * @author Chauncy
 *
 */
public class GrammerTest {
	
    public static void main(String[] args) {
//      System.out.println(args[0].getClass());
//      System.out.println(args[1].getClass());           //������ΪString����
    }
    
    @Test
    public void test2() {
    	int i = 10;
        float f = 20.000001f;
        double d = 22.000000001d;
        char c = 43;
        byte b = 11;
        boolean bool = true;
        System.out.println(i);
        System.out.println(f);
        System.out.println(f - 20);               //С��������ʧ����
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);
        System.out.println(bool);
    }

    @Test
    public void test3() {
        int x = 110;                 //ֱ����Ĭ��Ϊint����
        int y = 0b1101110;            //�����Ʊ�ʾ0b,�˽��ƣ�0,ʮ������0x
        int z = 0x41;
        byte b = 127;
        char c = '\u0041';           //unicode���룺(\\u)4λʮ�����Ʊ�ʾ�ַ� 4*4=16=2*8�����ֽ�
        char c1 = 'a';
        char c2 = 22;
        long l = 23L;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(b);
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(l);
    }

    @Test
    public void test4() {
        byte b = 22;
        short s = b;
        System.out.println(s);

        char c1 = 'C';
        char c2 = 'D';             
        //����byte,char,short��Ӷ�Ϊint
        System.out.println(c1+c2);

//	    System.out.println(10/0);
        System.out.println("result :"+10.0/0);
        System.out.println(10/0.0);                //   10/0.0=�����
        System.out.println(0/0.0);                 //    0.0/0.0=NaN
        double a = 0/0.0;
        System.out.println(a == a);               //    NaN ������NaN
        System.out.println(10 % 3);
        System.out.println(9.0 % 3);
    }
    

}
