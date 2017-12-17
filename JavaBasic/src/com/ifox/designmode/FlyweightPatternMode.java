package com.ifox.designmode;

import java.util.HashMap;
import java.util.Map;
/**
 * 享元模式 String,Integer类简单实现
 * @author Chauncy
 *
 */
public class FlyweightPatternMode {
	
	public static void main(String[] args) {
		Integers x = Integers.valueOf(67);
		Integers y = Integers.valueOf(67);
		Integers z = new Integers(67);
		System.out.println(x == y);
		System.out.println(x == z);
		
		Strings strs1 = Strings.valueOf("aaa");
		Strings strs2 = Strings.valueOf("aaa");
		char[] char1 = "aaa".toCharArray();
		Strings strs3 = new Strings(char1);
		System.out.println(strs1 == strs2);
		System.out.println(strs1 == strs3);
	}

}

final class Integers {
	
	private final int i;
	
	public Integers(int i) {
		this.i = i;
	}
	
	public static Integers valueOf(int i) {
		if(i >= CacheInteger.LOW && i <= CacheInteger.HIGH) {
			return CacheInteger.CACHE[i];
		}
		return new Integers(i);
	}
	
	private static class CacheInteger {
		static Integers[] CACHE;
		static int LOW = -128;
		static int HIGH = 127;
		static {
			CACHE = new Integers[HIGH - LOW + 1];
			for (int i = 0; i < CACHE.length; i++) {
				CACHE[i] = new Integers(i + LOW);
			}
		}
	}
	
	public String toString(){
		return i + "";
	}
	
}

final class Strings {
	
	final char[] charArray;
	
	private int hash;
	
	public Strings (char[] chars){
		this.charArray = chars;
		for (char c : chars) {
			hash += 31 * hash + c;
		}
	}
	
	private static Integer getHash(String str) {
		int hash = 0;
		for (char c : str.toCharArray()) {
			hash += 31 * hash + c;
		}
		return hash;
	}
	
	public static Strings valueOf(String str) {
		Integer hash = getHash(str);
		Strings strs = StringsPool.StringsCache.get(hash);
		if(strs != null) {
			return strs;
		}
		strs = new Strings(str.toCharArray());
		StringsPool.StringsCache.put(hash, strs);
		return strs;
	}
	
	private static class StringsPool{
		public static final Map<Integer, Strings> StringsCache = new HashMap<Integer, Strings>();
	}
	
}