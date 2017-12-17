package com.ifox.interview;
/**
 * 考察继承结构对象方法执行过程
 * @author Chauncy
 *
 */
public class Extend1 {
	
	public static void main(String[] args) {
		System.out.println(new BB().getValue());
	}
	
	static class AA {
		protected int value;
		public AA(int v) {
			setValue(v);
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getValue() {
			try {
				value ++;
				return value;
			} finally {
				this.setValue(value);
				System.out.println(value);
			}
		}
	}
	
	static class BB extends AA {
		public BB() {
			super(5);
			setValue(getValue() - 3);
		}
		public void setValue(int value) {        //方法覆盖
			super.setValue(2*value);		//调用父类方法
		}
	}
}
