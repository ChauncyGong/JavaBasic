package com.ifox.thread;

/**
 * 鸡和蛋的哲学
 * @author Chauncy
 *
 */
public class DeathLock {
	
	static class Chicken {
		public Chicken (Egg egg) {}
	}
	static class Egg {
		public Egg (Chicken chicken) {}
	}
	
	private static Chicken chicken = null;
	private static Egg egg = null;
	
	public synchronized Chicken getChicken() {
		try {
			while (egg == null) {
				System.out.println("要有鸡，得先有蛋，等待一颗蛋");
				getEgg();
				this.wait();
			}
			chicken = new Chicken(egg);
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return chicken;
	}
	
	public synchronized Egg getEgg() {
		try {
			while (chicken == null) {
				System.out.println("要有蛋，得先有鸡，等待一只鸡");
				getChicken();
				this.wait();
			}
			egg = new Egg(chicken);
			this.notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return egg;
	}
	
	public static void main(String[] args) {
		new DeathLock().getChicken();
	}
}
