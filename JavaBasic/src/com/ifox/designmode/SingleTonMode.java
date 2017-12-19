package com.ifox.designmode;

//单例模式要求：一个 类有且只有一个实例对象
//方法：	1.构造器私有，不能手动创建对象
//		2.声明一个静态实例
//		3.定义一个静态的获取实例的方法，返回该实例

/**
 * 1.饿汉式：加载类时就创建实例对象
 */
public class SingleTonMode {
	private static SingleTonMode instance = new SingleTonMode();
	private SingleTonMode() {}
	public static SingleTonMode getInstance() {
		return instance;
	}
}

/**
 * 2.懒汉式（非线程安全）：需要获取实例时再创建对象
 */
class SingleTon3 {
	private static SingleTon3 instance = null;
	private SingleTon3() {}
	public SingleTon3 getInstance() {
		/**
		 * 当instance等于null时，多个线程同时调用此方法，则会创建多个实例对象
		 * 线程不安全
		 */
		if (instance == null) {
			instance = new SingleTon3();
		}
		return instance;
	}
	
}
/**
 * 3.懒汉式（线程安全）
 */
class SingleTon4 {
	private static SingleTon4 instance = null;
	private SingleTon4() {}
	/**
	 * 加入同步操作
	 */
	public synchronized SingleTon4 getInstance() {
		/**
		 * 如果instance不为null，获取实例也进行了同步操作，损耗性能
		 * 应尽量减小synchronized同步的范围，因此有下面的双重校验锁
		 */
		if (instance == null) {
			instance = new SingleTon4();
		}
		return instance;
	}
}
/**
 * 4.双重校验锁
 * （线程安全）懒汉式的优化版
 */
class SingleTon5 {
	//注意此处必须加volatile关键字，表示其不会被本地线程缓存，对多个线程可见，即线程共享
	private static volatile SingleTon5 instance = null;
	private SingleTon5() {}
	public static SingleTon5 getInstance() {
		//instance不为空直接返回，不会进行同步
		if (instance == null) {
			//此时多个线程访问此方法，存在instance为空的情况，在需要创建对象时再进行同步
			synchronized(SingleTon5.class) {	//将单例类的class对象监听同步
				//在同步中确认单个线程访问时instance的状态，为null才创建实例
				if (instance == null) {
					instance = new SingleTon5();
				}
			}
		}
		return instance;
	}
}
/**
 * 5.静态内部类
 * 此种方式既可以实现延迟加载，又保证了线程安全
 * 在获取实例时才会加载内部类，并创建实例
 */
class SingleTon6 {
	private static final class SingletonHolder {
		private static final SingleTon6 INSTANCE = new SingleTon6();
	}
	private SingleTon6() {}
	public static final SingleTon6 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
/**
 * 6.枚举方式，保证了安全性，即使通过反射不能创建对象
 */
enum SingleTon7 {
	INSTANCE;
}

