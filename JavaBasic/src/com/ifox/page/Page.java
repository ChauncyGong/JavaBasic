package com.ifox.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现分页
 * @author Chauncy
 *
 */
public class Page<T> {
	
	public static final int PAGE_SIZE = 10;
	
	public static final int NAVIGATE_SIZE = 5;

	//总记录数
	private int totalCount;
	
	private int pageCount;

	private int currentPage;
	
	private int[] navigate;
	
	private boolean hasPrevious;
	
	private boolean hasNext;
	
	private List<T> pageList;

	private List<T> list;
	
	public Page() {};
	
	public Page(List<T> list) {
		this.list = list;
		totalCount = list.size();
		pageCount = totalCount % PAGE_SIZE == 0 
				? totalCount / PAGE_SIZE : totalCount / PAGE_SIZE +1;
	}
	
	public Page<T> next() {
		return getPage(currentPage + 1);
	}
	
	public Page<T> previous() {
		return getPage(currentPage - 1);
	}
	
	private boolean hasPreviousPage() {
		return currentPage != 1;
	}
	
	private boolean hasNextPage() {
		return currentPage < pageCount;
	}
	
	private int[] getNavigate(int pageNo) {
		int start = pageNo - NAVIGATE_SIZE / 2;
		if (pageNo <= NAVIGATE_SIZE / 2) {
			start = 1;
		} else if (pageNo > pageCount - NAVIGATE_SIZE / 2) {
			start = pageCount - NAVIGATE_SIZE + 1;
		}
		int[] navigate = new int[NAVIGATE_SIZE];
		for (int i = 0; i < NAVIGATE_SIZE; i++) {
			navigate[i] = start + i;
		}
		return navigate;
	}
	
	public Page<T> getPage(int pageNo){
		if (pageNo > pageCount) {
			return getPage(pageCount);
		} else if (pageNo < 1){
			return getPage(1);
		}
		currentPage = pageNo;
		navigate = getNavigate(pageNo);
		hasPrevious = hasPreviousPage();
		hasNext = hasNextPage();
		pageList = list.subList((currentPage-1) * PAGE_SIZE,
				hasNext ? currentPage * PAGE_SIZE : totalCount); 
		return this;
	}
	
	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ ", navigate=" + Arrays.toString(navigate) + ", hasPrevious=" + hasPrevious + ", hasNext=" + hasNext
				+ ", pageList=" + pageList + "]";
	}

	
	//测试代码
	public static void main(String[] args) {
		
		int pageNo = 16;
		
		List<Integer> ids = new ArrayList<>();
		for(int i = 0; i < 155; i++) {
			ids.add(i + 1);
		}
		System.out.println(new Page<Integer>(ids).getPage(pageNo).next());
	}
}
