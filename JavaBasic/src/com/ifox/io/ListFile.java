package com.ifox.io;

import java.io.File;

import org.junit.Test;

public class ListFile {
	
	public void listAllFile(File file) {
		if (file.isDirectory()) {
			for (File file2 : file.listFiles()) {
				listAllFile(file2);
			}
		}else {
			System.out.println(file);
		}
	}

	@Test
	public void getAllFile() {
		File file = new File("f:\\");
		listAllFile(file);
	}
}
