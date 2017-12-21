package com.ifox.datastructure;

public class IStack extends IlinkedList{
	
	public IStack() {}
	
	//获取栈顶元素
	public Object peek() {
		return get(0);
	}
	
	//压栈
	public void push(Object obj) {
		super.addFirst(obj);
	}
	
	//出栈
	public Object pop() {
		Object obj = peek();
		super.deleteFirst();
		return obj;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//获取栈元素数
	public int size() {
		return super.size();
	}
	
	//测试
	public static void main(String[] args) {
		IStack stack = new IStack();
		System.out.println(stack.isEmpty());
		stack.push("1");
		stack.peek();
		stack.push("2");
		stack.push("3");
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
