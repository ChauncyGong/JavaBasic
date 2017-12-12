package com.ifox.basic.test;

import org.junit.Test;

/**
 * 基础语法测试
 * @author Chauncy
 *
 */
public class GrammerTest {
	
    public static void main(String[] args) {
//      System.out.println(args[0].getClass());
//      System.out.println(args[1].getClass());           //参数都为String类型
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
        System.out.println(f - 20);               //小数精度损失问题
        System.out.println(d);
        System.out.println(c);
        System.out.println(b);
        System.out.println(bool);
    }

    @Test
    public void test3() {
        int x = 110;                 //直接量默认为int类型
        int y = 0b1101110;            //二进制表示0b,八进制：0,十六进制0x
        int z = 0x41;
        byte b = 127;
        char c = '\u0041';           //unicode编码：(\\u)4位十六进制表示字符 4*4=16=2*8两个字节
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
        //两个byte,char,short相加都为int
        System.out.println(c1+c2);

//	    System.out.println(10/0);
        System.out.println("result :"+10.0/0);
        System.out.println(10/0.0);                //   10/0.0=无穷大
        System.out.println(0/0.0);                 //    0.0/0.0=NaN
        double a = 0/0.0;
        System.out.println(a == a);               //    NaN 不等于NaN
        System.out.println(10 % 3);
        System.out.println(9.0 % 3);
    }
    

}
