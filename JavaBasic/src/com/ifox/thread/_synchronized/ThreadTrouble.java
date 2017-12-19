package com.ifox.thread._synchronized;

class Apple implements Runnable{
	
	private int count = 50;

	@Override
	public void run() {
		while(count > 0) {
			/**
			 * 此处Thread.sleep()方法抛出了一个InterruptedException
			 * 在run方法内不能向上抛出，只能捕获
			 * 因为父类Thread、接口中的run方法没有抛出异常，子类或实现类不能在复写方法中抛出新的异常
			 */
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "吃了第" + count + "个苹果！");
			count--;
		}
	}
}

public class ThreadTrouble {
	
	/**
	 * 并发访问同一个对象，会出现多个人吃了同一个苹果
	 * 加入Thread.sleep()方法效果更明显，甚至会出现吃了负数个苹果的情况
	 */
	public static void main(String[] args) {
		Apple apple = new Apple();
		Thread thread1 = new Thread(apple, "AA");
		Thread thread2 = new Thread(apple, "BB");
		Thread thread3 = new Thread(apple, "CC");
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}
