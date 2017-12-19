package com.ifox.thread._synchronized;

class Apple3 implements Runnable{
	
	private int count = 50;

	@Override
	public void run() {
		while(count > 0) {
			eat();
		}
	}
	
	public synchronized void eat() {
		try {
			if (count > 0) {
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + "吃了第" + count + "个苹果！");
				count--;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SynchronizedMethodDemo {

	public static void main(String[] args) {
		Apple3 apple = new Apple3();
		Thread thread1 = new Thread(apple, "AA");
		Thread thread2 = new Thread(apple, "BB");
		Thread thread3 = new Thread(apple, "CC");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
