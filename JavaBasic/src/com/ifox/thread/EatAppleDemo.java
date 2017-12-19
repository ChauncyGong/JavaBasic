package com.ifox.thread;

import org.junit.Test;

/**
 * 吃苹果比赛
 * @author Chauncy
 *
 */
public class EatAppleDemo {

	public static void main(String[] args) {
		Thread thread1 = new People("AA");
		Thread thread2 = new People("BB");
		Thread thread3 = new People("CC");
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Test
	public void eatApple() {
		/**
		 * 三个线程使用同一个runable对象，即使用runable接口可实现线程共享
		 */
		Runnable people = new People2();
		Thread thread1 = new Thread(people, "AA");
		Thread thread2 = new Thread(people, "BB");
		Thread thread3 = new Thread(people, "CC");
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}

class People extends Thread{
	
	private static int count = 50;
	
	public People(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while (count > 0) {
			System.out.println(getName() + " 吃了第 " + count-- + "个苹果");
		}
	}
}

class People2 implements Runnable {
	
	private int count = 50;			//同样共同的50个苹果，使用实现方式可以不用static修饰
	
	@Override
	public void run() {
		while (count > 0) {
			System.out.println(Thread.currentThread().getName() 
					+ " 吃了第 " + count-- + "个苹果");
		}
	}
}
