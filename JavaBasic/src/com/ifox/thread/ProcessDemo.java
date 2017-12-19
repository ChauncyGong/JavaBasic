package com.ifox.thread;

import java.io.IOException;

/**
 * 操作进程
 * @author Chauncy
 *
 */
public class ProcessDemo {
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * 方式一：使用Runtime类的exec()
		 */
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("notepad");
		
		/**
		 * 方式二：ProcessBuilder的start方法
		 */
		ProcessBuilder pb = new ProcessBuilder("mspaint");
		pb.start();
	}

}
