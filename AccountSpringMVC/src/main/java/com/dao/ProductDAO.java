package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDAO {
	public int saveProduct(Product pd);
	public int updateProduct(Product pd);
	public int deleteProduct(Product pd);
	public Product getProductById(int pid) ;
	public List<Product> getProductList();
}
