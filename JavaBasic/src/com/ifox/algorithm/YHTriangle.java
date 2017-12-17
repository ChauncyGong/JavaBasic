package com.ifox.algorithm;

import org.junit.Test;

/**
 * 杨辉三角实现
 * @author Chauncy
 *
 */
public class YHTriangle {
	
	@Test
	public void run() throws Exception {
		printTriangle(5);
	}
	
	/**
	 * 
	 * @param floors 楼层数
	 * @return 表示杨辉三角的int型的二维数组对象
	 * @throws Exception 楼层数不能小于3
	 */
	public int[][] getTriangle (int floors) throws Exception {
		if (floors < 3) {
			throw new Exception("参数错误");
		}
		int[][] triangelArray = new int[floors][]; 
		triangelArray[0] = new int[]{1};
		triangelArray[1] = new int[]{1, 1};
		for (int i = 2; i < floors; i++) {
			triangelArray[i] = new int[i + 1];
			triangelArray[i][0] = 1;
			for (int j = 1; j < i; j++) {
				triangelArray[i][j] = triangelArray[i - 1][j - 1] + triangelArray[i - 1][j];
			}
			triangelArray[i][i] = 1;
		}
		return triangelArray;
	}
	
	//打印杨辉三角
	public void printTriangle(int floors) throws Exception {
		for (int[] column : getTriangle(floors)) {
			for (int i = column.length; i < floors; i++) {
				System.out.print("  ");
			}
			for (int i = 0; i < column.length; i++) {
				System.out.print(column[i] + "   ");
			}
			System.out.println();
		}
	}
}
