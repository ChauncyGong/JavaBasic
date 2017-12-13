package com.ifox.algorithm;

import java.util.Scanner;

public class GobangGame {
	
	public static final int CHECKERBOARD_DEFAULT_SIZE = 20;
	
	public static final char DEFAULT = '-';
	
	public static final char RED = 'X';
	
	public static final char BLACK = '0';
	
	char[][] checkerboard;
	
	int size;
	
	int curX;
	
	int curY;
	
	char role;
	
	public void init(int size) {
		this.size = size;
		checkerboard = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < checkerboard[i].length; j++) {
				checkerboard[i][j] = DEFAULT;
			}
		}
		printCheckerboard();
	}
	
	public void chess(int x, int y, char c) throws Exception{
		if(x < 0 || y < 0 || x > size -1 || y > size -1 || checkerboard[y][x] != DEFAULT) {
			throw new Exception("参数错误");
		};
		curX = x;
		curY = y;
		checkerboard[y][x] = c;
		role = c;
		printCheckerboard();
	}
	
	public boolean checkWin() {
		return getMax(checkHorizontal(),checkVertical(),checkSlash(), checkBackSlash()) > 4;
	}
	
	private int getMax(int... is) {
		int max = 0;
		for (int i : is) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	
	private int checkHorizontal () {
		int count = 0;
		if(curX != 0) {
			for (int i = curX-1; i >= 0; i--) {
				if(checkerboard[curY][i] != role) {
					break;
				}
				count ++;
			}
		}
		for (int i = curX; i < size; i++) {
			if(checkerboard[curY][i] != role) {
				break;
			}
			count ++;
		}
		return count;
	}
	
	private int checkVertical() {
		int count = 0;
		if(curY != 0) {
			for (int i = curY-1; i >= 0; i--) {
				if(checkerboard[i][curX] != role) {
					break;
				}
				count ++;
			}
		}
		for (int i = curY; i < size; i++) {
			if(checkerboard[i][curX] != role) {
				break;
			}
			count ++;
		}
		return count;
	}
	
	private int checkSlash() {
		int count = 0;
		if(curX != 0) {
			for (int i = curX - 1, j = curY + 1; i >= 0 || j < size; i--, j++) {
				if(checkerboard[j][i] != role) {
					break;
				}
				count ++;
			}
		}
		for (int i = curX, j = curY; i < size && j >= 0; i++, j--) {
			if(checkerboard[j][i] != role) {
				break;
			}
			count ++;
		}
		return count;
	}
	
	private int checkBackSlash() {
		int count = 0;
		if(curX != 0) {
			for (int i = curX-1, j = curY-1; i >= 0 || j >= 0; i--, j--) {
				if(checkerboard[j][i] != role) {
					break;
				}
				count ++;
			}
		}
		for (int i = curX, j = curY; i < size && j < size; i++, j++) {
			if(checkerboard[j][i] != role) {
				break;
			}
			count ++;
		}
		return count;
	}
	
	public void printCheckerboard() {
		StringBuilder sb = new StringBuilder();
		sb.append("    ");
		for (int i = 0; i < size; i++) {
			if(i < 9) {
				sb.append(i + "  ");
			}else {
				sb.append(i + " ");
			}
		}
		sb.append("\n");
		int no = 0;
		for (char[] column : checkerboard) {
			if (no < 10) sb.append(" ");
			sb.append(no++ + " [");
			for (int i = 0; i < column.length; i++) {
				if(i == column.length - 1) {
					sb.append(column[i]);
					break;
				}
				sb.append(column[i] + "  ");
			}
			sb.append("]\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) {
		//初始化游戏
		GobangGame game = new GobangGame();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); 
		game.init(CHECKERBOARD_DEFAULT_SIZE);
		System.out.println("来一场你死我活的SOLO吧!");
		
		boolean turn = false;
		while(true) {
			System.out.print("请" + (turn ? "红方":"黑方")+"落子(格式为 x y) :");
			char c = turn ? RED : BLACK;
			
			//获取落子位置
			try {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				game.chess(x, y, c);
			} catch (Exception e) {
				System.out.println("警告！参数错误!");
				continue;
			}
			
			//判定胜负
			if(game.checkWin()) {
				System.out.println((turn ? "红方":"黑方")+"获胜！");
				System.exit(0);
			}
			turn = !turn;
		}
	}
	
	
}
