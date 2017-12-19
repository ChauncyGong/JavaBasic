package com.ifox.thread.communication;

import java.util.Arrays;

/**
 * 抢车位
 * @author Chauncy
 *
 */
public class ThreadDemo {
	
	private static final int CAR_COUNT = 20;
	private static final int MAX_SIZE = 5;
		
	public static void main(String[] args) {
		Park park = new Park(MAX_SIZE);
		Car[] cars = new Car[CAR_COUNT];
		for (int i = 0; i < CAR_COUNT; i++) {
			cars[i] = new Car("车辆" + (i + 1), park);
		}
		for (int i = 0; i < cars.length; i++) {
			new Thread(cars[i]).start();
		}
//		new Thread(cars[0]).start();
	}
	
}
class Park {
	
	boolean[] parkingSpace = null;
	boolean isfull = false;
	
	public Park(int size) {
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
	
	public synchronized int push(String name) throws InterruptedException {
		int index = getFreeIndex();
		while (isfull) {
			this.wait();
			index = getFreeIndex();
		}
		parkingSpace[index] = true;
		System.out.println(name + "进入了车位【" + (index + 1) + "】");
		System.out.println(this);
		return index + 1;
	}
	
	public synchronized void pop(String name, int index) {
		if (index > parkingSpace.length -1 || index < 0) {
			System.out.println("参数错误");
			return;
		}
		parkingSpace[index] = false;
		isfull = false;
		System.out.println(name + "离开了车位【" + (index + 1) + "】");
		System.out.println(this);
		this.notifyAll();
	}
	
	public String toString() {
		return Arrays.toString(parkingSpace);
	}
}

class Car implements Runnable{
	
	private String name;
	
	private Park park;
	
	public Car(String name, Park park) {
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