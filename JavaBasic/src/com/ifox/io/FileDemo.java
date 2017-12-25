package com.ifox.io;

import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class FileDemo {
	
	@Test
	public void testSeparator() {
		String pathSeparator = File.pathSeparator;
		char pathSeparatorChar = File.pathSeparatorChar;
		
		String separator = File.separator;
		char separatorChar = File.separatorChar;
		
		System.out.println(pathSeparator);
		System.out.println(pathSeparatorChar);
		
		System.out.println(separator);
		System.out.println(separatorChar);
	}
	
	
	@Test
	public void file() {
		
//		String path1 = "e:\\program\\a.txt";
//		String path2 = "e:/program/a.txt";
		/**
		 * 建议使用以下方式
		 */
		String path3 = "E:" + File.separator + "program" + File.separator + "a.txt";
		File file = new File(path3);
		System.out.println(file);
		System.out.println(file.exists());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.canExecute());
		System.out.println(file.canRead());
		System.out.println(file.length());
		
		File[] listRoots = File.listRoots();
		for (File file2 : listRoots) {
			System.out.println(file2);
		}
	}
	
	@Test
	public void testFileIO() throws Exception {
		
	}
	
	public static void main(String[] args) throws Exception {
		File src = new File("file\\a.txt");
//		FileInputStream out = new FileInputStream(src);
//		byte[] buffer = new byte[5];
//		int len = 0;
//		while ((len = out.read(buffer)) > 0) {
//			System.out.println(new String(buffer, 0, len));
//		}
//		out.close();
		
		FileReader reader = new FileReader(src);
		char[] buffer = new char[5];
		int len = 0;
		while ((len = reader.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
		reader.close();
	}
	
}
