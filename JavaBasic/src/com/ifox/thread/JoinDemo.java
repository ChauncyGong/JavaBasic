package com.ifox.thread;

class Join implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(i);
		}
	}
}

public class JoinDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Join join = new Join();
		Thread thread = new Thread(join);
		for (int i = 0; i < 50; i++) {
			if (i == 18) {
				thread.start();
			}
			if (i == 20) {
				thread.join();
			}
			System.out.println("main : " + i);
		}
	}
}
