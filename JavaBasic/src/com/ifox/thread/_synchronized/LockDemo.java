package com.ifox.thread._synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Apple4 implements Runnable{
	
	private int count = 50;
	
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while(count > 0) {
			try {
				/**
				 * 和同步代码块相似，只是采用面向对象的方式进行同步操作罢了
				 * 在需同步代码块前加锁，需同步的代码后释放锁
				 */
				lock.lock();		//加锁
				if (count > 0) {
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName() + "吃了第" + count + "个苹果！");
					count--;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();		//释放锁
			}
		}
	}
}

public class LockDemo {
	
	public static void main(String[] args) {
		Apple4 apple = new Apple4();
		Thread thread1 = new Thread(apple, "AA");
		Thread thread2 = new Thread(apple, "BB");
		Thread thread3 = new Thread(apple, "CC");
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}
