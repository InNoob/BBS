package com.util;

import java.util.*;

public class Pager<T> {
	private int pageNo;
	private int totalPage;
	private static final int size = 15;
	private List<T> list;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public static int getSize() {
		return size;
	}
}
