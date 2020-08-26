package yntc.domain;


import java.util.List;

public class PageBean<E>{
     private int currentPage;//当前页
     private int pageSize;//每页显示几条
     private int count;//查询总条数
     private int totalPage;//总页数
     private List<E> list;
     private String words;
	
	public PageBean() {
		super();
		
	}

	public PageBean(int currentPage, int pageSize, int count, int totalPage, List<E> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.totalPage = totalPage;
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	
	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", count=" + count + ", totalPage="
				+ totalPage + ", list=" + list + ", words=" + words + "]";
	}

	
	
}
