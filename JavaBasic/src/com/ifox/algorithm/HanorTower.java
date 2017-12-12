package com.ifox.algorithm;

import java.util.Arrays;

import org.junit.Test;

//ººÂÞËþ³ÌÐò
public class HanorTower {
	
	@Test
	public void run() {
		
		int default_size = 10;
		Column A = new Column("A", default_size, true);
		Column B = new Column("B", default_size);
		Column C = new Column("C", default_size);
		
		System.out.println("" + A + B + C);
		exchange(A, B, C, default_size);
		System.out.println("" + A + B + C);

	}
	
	public void exchange(Column from, Column bridge, Column to , int num) {
		if(num == 2) {
			from.moveTo(bridge);
			from.moveTo(to);
			bridge.moveTo(to);
			return;
		}
		exchange(from, to, bridge, num - 1);
		from.moveTo(to);
		exchange(bridge, from, to, num - 1);
	}
	
}

class Column {
	
	public String name;
	
	public int[] disks;
	
//	public List<Integer> disks = new ArrayList<>();
	
	public Column() {}
	
	public Column(String name, int size) {
		this.name = name;
		disks = new int[size];
	}
	
	public Column(String name, int size, boolean init) {
		this(name, size);
		if (init) {
			for (int i = 0; i < disks.length; i++) {
				disks[i] = i + 1;
			}
		}
	}
	
	public void moveTo(Column to) {
		System.out.println(name + " ÒÆ¶¯µ½ " + to.name);
		int i = 0;
		int obj = disks[0];
		for(i = 0; i < disks.length - 1; i++) {
			disks[i] = disks[i + 1];
			if (disks[i + 1] == 0) {
				break;
			}
		}
		disks[disks.length - 1] = 0;
		for(i = to.disks.length; i > 0; i--) {
			if (to.disks[i - 1] == 0) {
				continue;
			}
			to.disks[i] = to.disks[i - 1];
		}
		to.disks[0] = obj;
		System.out.println("" + this + to);
	}

	@Override
	public String toString() {
		return name + " : " + Arrays.toString(disks) + "\n";
	}
	
}