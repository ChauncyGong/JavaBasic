package com.ifox.datastructure;

public class IArrayList {

	private static final int DEFAULT_CAPACITY = 10;
	
	private int capacity;
	
	protected Object[] elements;
	
	private int size;
	
	public IArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public IArrayList(int capacity) {
		elements = new Object[capacity];
		this.capacity = capacity;
	}
	
	//	查找索引对应的元素
	public Object get(int index) {
		checkIndex(index);
		return elements[index];
	}
	
	//	查找元素内容对象的索引
	public int getIndex(Object obj) {
		for (int i = 0; i < size; i++) {
			if(elements[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	//	添加元素
	public int add(Object obj) {
		if (size == capacity) {
			expandCapacity();
		}
		elements[size] = obj;
		size ++;
		return size - 1;
	}
	
	//	在指定位置处插入元素
	public int add(int index, Object obj) {
		checkIndex(index);
		if (size == capacity) {
			expandCapacity();
		}
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = obj;
		size ++;
		return index;
	}
	
	//	修改指定位置处元素
	public void update(int index, Object obj) {
		checkIndex(index);
		elements[index] = obj;
	}
	
	//	删除指定位置的元素
	public void delete(int index) {
		checkIndex(index);
		for (int i = index; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size--] = null;
	}
	//	删除指定内容的元素
	public void delete(Object obj) {
		int index = getIndex(obj);
		if (index != -1) {
			delete(index);
		}
	}
	
	//	返回集合大小
	public int size() {
		return size;
	}
	
	//检查索引越界
	private void checkIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
	
	//数组扩容
	private void expandCapacity() {
		Object[] newElements = new Object[capacity * 2];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
		capacity *= 2;
	}
	
	//	输出集合
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size - 1; i++) {
			sb.append(elements[i] + ", ");
		}
		sb.append(elements[size - 1] + "]");
		return sb.toString();
	}
	
	//测试
	public static void main(String[] args) {
		IArrayList iArrayList = new IArrayList();
		for (int i = 0; i < 12; i++) {
			iArrayList.add(i + "");
		}
		System.out.println(iArrayList);
//		System.out.println(iArrayList.get(-1));
//		System.out.println(iArrayList.get(11));
//		System.out.println(iArrayList.get(12));
		System.out.println(iArrayList.getIndex("10"));
		System.out.println(iArrayList.getIndex("00"));
		iArrayList.add("12");
		iArrayList.add("13");
		iArrayList.add(5, "13");
		iArrayList.delete(14);
		iArrayList.delete("11");
		System.out.println(iArrayList);
		System.out.println(iArrayList.size());
		System.out.println(iArrayList.capacity);
	}
	
}
