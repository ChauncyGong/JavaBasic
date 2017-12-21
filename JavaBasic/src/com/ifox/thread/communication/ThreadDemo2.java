package com.ifox.thread.communication;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 {
		
	private static final int CAR_COUNT = 20;
	private static final int MAX_SIZE = 5;
		
	public static void main(String[] args) {
		Park2 park = new Park2(MAX_SIZE);
		Car2[] cars = new Car2[CAR_COUNT];
		for (int i = 0; i < CAR_COUNT; i++) {
			cars[i] = new Car2("车辆" + (i + 1), park);
		}
		for (int i = 0; i < cars.length; i++) {
			new Thread(cars[i]).start();
		}
	}
	
}
class Park2 {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	boolean[] parkingSpace = null;
	boolean isfull = false;
	
	public Park2(int size) {
		parkingSpace = new boolean[size];
	}
	
	private int getFreeIndex() {
		for (int i = 0; i < parkingSpace.length; i++) {
			if (parkingSpace[i] == false) {
				return i;
			}
		}
		isfull = true;
		return -1;
	}
	
	public int push(String name) throws InterruptedException {
		lock.lock();
		int index = getFreeIndex();
		while (isfull) {
			condition.await();
			index = getFreeIndex();
		}
		parkingSpace[index] = true;
		System.out.println(name + "进入了车位【" + (index + 1) + "】");
		System.out.println(this);
		lock.unlock();
		return index + 1;
	}
	
	public synchronized void pop(String name, int index) {
		lock.lock();
		if (index > parkingSpace.length -1 || index < 0) {
			System.out.println("参数错误");
			return;
		}
		parkingSpace[index] = false;
		isfull = false;
		System.out.println(name + "离开了车位【" + (index + 1) + "】");
		System.out.println(this);
		condition.signalAll();
		lock.unlock();
	}
	
	public String toString() {
		return Arrays.toString(parkingSpace);
	}
}

class Car2 implements Runnable{
	
	private String name;
	
	private Park2 park;
	
	public Car2(String name, Park2 park) {
		this.name = name;
		this.park = park;
	}
	
	@Override
	public void run() {
		try {
			int position = park.push(name);
			Thread.sleep(3000);
			park.pop(name, position - 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}