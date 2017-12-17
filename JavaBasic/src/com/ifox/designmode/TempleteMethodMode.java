package com.ifox.designmode;
/**
 * 模板方法设计模式示例
 * @author Chauncy
 *
 */
public class TempleteMethodMode {

	public static void main(String[] args){
        Work work1 = new PrintWork();
        long time1= work1.getTotalTime();             //调用模板方法，实际操作有调用对象提供
        System.out.println("work1 花费的时间为：" + time1 + "毫秒");  
      
        Work work2 = new AddWork();
        long time2 = work2.getTotalTime();
        System.out.println("work1 花费的时间为：" + time2 + "毫秒");
    }
}

abstract class Work {
	/**
	 * 模板方法，提供通用算法操作，具体实现由子类完成
	 */
	public final long getTotalTime() {                //此处声明为final，防止子类复写方法修改算法
	    long start = System.currentTimeMillis();
	    doWork();                                        //回调子类的方法实现
	    long end = System.currentTimeMillis();
	    return end - start;
	}

	protected abstract void doWork();              //此处声明为protected只让子类继承该方法，并提供实现细节
}

class PrintWork extends Work {                 //子类提供抽象方法的实现细节
    public void doWork() {
        for(int i = 0; i < 1000; i ++) {
            System.out.println(i);
        }
    }
}

class AddWork extends Work {
    public void doWork() {
        int result = 0;
        for(int i = 0; i < 10000; i ++) {
            result += i;
        }
        System.out.println(result);
    }
}

