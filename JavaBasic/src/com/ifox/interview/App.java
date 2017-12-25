package com.ifox.interview;

/**
 * 考察创建类时类加载执行顺序
 * @author Chauncy
 *
 */
public class App {

	public static App app = new App();
	public SuperClass sbClass = new SubClass();		//App类包含SubClass对象，即依赖于SubClass
													//所以先加载Subclass类的字节码
	
	static {
		//静态app对象初始化类似如下
		//app = new App();
		System.out.println("1");
	}
	
	public App() {
		//字段初始化类似如下
		//sbClass = new SubClass();
		System.out.println("2");
	}
	
	public static void main(String[] args) {
		
		//预测结果： 4 6 5 7 2 1 3    正确
		System.out.println("3");
	}
	
}

class SuperClass {
	
	static {
		System.out.println("4");
	}
	
	public SuperClass() {
		System.out.println("5");
	}
}

class SubClass extends SuperClass {
	
	static {
		System.out.println("6");   //SubClass依赖SuperClass,故先加载父类字节码对象 
	}
	
	public SubClass() {
		System.out.println("7");	//创建子类对象之前会创建父类对象
	}
}