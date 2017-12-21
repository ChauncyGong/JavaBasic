package com.ifox.datastructure;

public class IlinkedList {
	
	private static class Node {
		public Node previous;
		public Node next;
		private Object element;
		
		public Node(Object element) {
			this.element = element;
		}
	}
	
	private int size;
	
	private Node first;
	
	private Node last;
	
	public IlinkedList() {}
	
	public IlinkedList(Object element) {
		Node node = new Node(element);
		first = node;
		last = node;
		size++;
	}
	
	//获取链表长度
	public int size() {
		return size;
	}
	
	//检查索引
	private void checkIndex(int index) {
		if (index >= size || size == 0) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	//查找索引为index的节点
	private Node getNode(int index) {
		checkIndex(index);
		Node node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	private Node getNode(Object obj) {
		Node node= first;
		for (int i = 0; i < size; i++) {
			if (obj.equals(node.element)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	//查找索引为index的节点的元素
	public Object get(int index) {
		checkIndex(index);
		return getNode(index).element;
	}

	//添加首节点
	public void addFirst(Object obj) {
		Node node = new Node(obj);
		if(first != null) {
			first.previous = node;
			node.next = first;
			first = node;
		}else {
			first = node;
			last = node;
		}
		size ++;
	}
	
	//添加尾节点
	public void add(Object obj) {
		Node node = new Node(obj);
		if (last != null) {
			last.next = node;
			node.previous = last;
			last = node;
		} else {
			first = node;
			last = node;
		}
		size ++;
	}
	
	//添加索引为x处添加一个节点
	public void addElement(int index, Object obj) {
		checkIndex(index);
		Node node = getNode(index);
		Node newNode = new Node(obj);
		node.next = newNode;
		newNode.previous = node;
		newNode.next = node.next;
		if(node.next != null) {
			node.next.previous = newNode;
		}
		size ++;
	}
	
	//修改指定索引元素值
	public void set(int index, Object obj) {
		checkIndex(index);
		getNode(index).element = obj;
	}
	
	//删除首节点
	public void deleteFirst() {
		if (size == 0) {
			return;
		} else if (size == 1) {
			first = null;
			last = null;
		}else {
			first = first.next;
			first.previous = null;
		}
		size --;
	}
	
	//删除尾节点
	public void deleteLast() {
		if(size == 0) {
			return;
		} else if (size == 1) {
			first = null;
			last = null;
		} else {
			last = last.previous;
			last.next = null;
		}
		size--;
	}
	
	//删除索引为index一个节点
	public void delete(int index) {
		checkIndex(index);
		Node node = getNode(index);
		if(node.previous != null) {
			node.previous.next = node.next;
		}
		if(node.next != null) {
			node.next.previous = node.previous;
		}
		size--;
	}
	
	public void delete(Object obj) {
		if (obj == null) {
			return;
		}
		Node node = getNode(obj);
		if (node != null) {
			if(node.previous != null) {
				node.previous.next = node.next;
			}
			if(node.next != null) {
				node.next.previous = node.previous;
			}
			size--;
		}
	}
	
	//输入链表
	public String toString() {
		if (size == 0) {
			return "[ ]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (Node node = first; node!= null; node = node.next) {
			sb.append(node.element + ", ");
		}
		return sb.substring(0, sb.length() - 2) + "]";
	}
	
	//测试
	public static void main(String[] args) {
		IlinkedList list = new IlinkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		System.out.println(list);
		list.addFirst("0");
		list.delete("3");
		System.out.println(list);
		list.deleteFirst();
		list.deleteLast();
		System.out.println(list);
		System.out.println(list.get(4));
		list.delete(2);
		list.set(0, 10);
		System.out.println(list);
	}
}
