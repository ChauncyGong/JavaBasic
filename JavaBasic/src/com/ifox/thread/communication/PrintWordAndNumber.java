package com.ifox.thread.communication;

/**
 * 输出数字字母
 * 要求:	12A34B56C.....5152C
 * 		采用多线程方式
 * @author Chauncy
 *
 */
public class PrintWordAndNumber {

	public static void main(String[] args) {
		Task task = new Task();
		new Thread(new PrintWordThread(task)).start();
		new Thread(new PrintNumberThread(task)).start();
	}
}

class Task {
	private boolean isNumber = true;

	public synchronized void printWord() {
		for (int i = 0; i < 26; i++) {
			try {
				while (isNumber) {
					this.wait();
				}
				System.out.print((char)('A' + i));
				Thread.sleep(500);
				isNumber = true;
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void printNumber() {
		for (int i = 0; i < 26; i++) {
			try {
				while (!isNumber) {
					this.wait();
				}
				System.out.print(" ");
				System.out.print(2 * i + 1);
				System.out.print(2 * i + 2);
				isNumber = false;
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class PrintWordThread implements Runnable {
	
	private Task task= null;
	
	public PrintWordThread(Task task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		task.printWord();
	}
}

class PrintNumberThread implements Runnable{
	
	private Task task= null;
	
	public PrintNumberThread(Task task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		task.printNumber();
	}
}
