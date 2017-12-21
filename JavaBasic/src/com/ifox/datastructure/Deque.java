package com.ifox.datastructure;

public class Deque extends IArrayList{
	
	public Deque() {}

	//入队
	public void offer(Object obj) {
		super.add(obj);
	}
	
	//出队
	public void pop() {
		super.delete(elements.length);
	}
	
	//返回长度
	public int size() {
		return super.size();
	}
	
	//查找
	public Object get(int index) {
		return super.get(index);
	}
}
