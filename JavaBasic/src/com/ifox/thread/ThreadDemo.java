package com.ifox.thread;

import org.junit.Test;

/**
 * 创建线程的几种方式
 * @author Chauncy
 *
 */
//此种方式的线程类不能继承与其他类
class Thread1 extends Thread {
	
	public void run() {					//线程执行体:run()
		/**
		 * 获取线程名字：getName()
		 */
		System.out.println("线程" + getName() + "开始");
		for (int i = 0; i < 10; i++) {
			System.out.println("下载文件" + i);
		}
		System.out.println("线程" + getName() + "结束");
	}
}

class Runable2 implements Runnable {
	
	@Override
	public void run() {
		/**
		 * 获取线程名字：Thread.currentThread().getName()
		 */
		System.out.println("线程" + Thread.currentThread().getName() + "开始");
		for (int i = 0; i < 10; i++) {
			System.out.println("听音乐" + i);
		}
		System.out.println("线程" + Thread.currentThread().getName() + "结束");
	}
}

public class ThreadDemo {

	@Test
	public void mainThreadTest() {
		Thread currentThread = Thread.currentThread();		//取得当前线程
		currentThread.setName("主线程");						//设置名字
		System.out.println(currentThread.getId());			//id从0开始累加
		System.out.println(currentThread.getName());		//主线程name默认为main
		System.out.println(currentThread.getPriority());	//默认线程优先级为NORM_PRIORITY-->5
		System.out.println(currentThread.isDaemon());
		/**
		 * java.lang.IllegalThreadStateException
		 * 主线程默认是前台线程，线程一旦运行不能重新设置为后台线程
		 */
		currentThread.setDaemon(true);						
		System.out.println(currentThread.isDaemon());
	}
	
	@Test
	public void createByExtends() {
		Thread1 thread1 = new Thread1();
		thread1.start();				//启动线程：start()
		/**
		 * java.lang.IllegalThreadStateException
		 * 线程只能执行一次
		 */
//		thread1.start();				
	}
	
	@Test
	public void createByImplements() {
		Runable2 runable2 = new Runable2();
		Thread thread = new Thread(runable2);
		thread.start();
	}
	
	/**
	 * 匿名内部类方式创建线程
	 */
	@Test
	public void innerClass() {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + i);
				}
			}
		}, "线程1");
		
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(getName() + i);
				}
			}
		};
		thread2.setName("线程2");
		thread1.start();
		thread2.start();
	}
}