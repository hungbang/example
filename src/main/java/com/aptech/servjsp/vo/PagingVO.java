package com.aptech.servjsp.vo;

import java.util.List;

import com.aptech.servjsp.Product;

public class PagingVO {
	private int pageNumber;
	private List<Product> products;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
