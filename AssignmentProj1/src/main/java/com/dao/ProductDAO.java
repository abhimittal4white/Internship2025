package com.dao;

import java.util.List;

import com.data.Product;

public interface ProductDAO {
	public int saveProduct(Product pd);
	public int updateProductName(Product pd);
	public int updateProductPrice(Product pd);
	public int deleteProduct(Product pd);
	public Product getProductById(int pid);
	public List<Product> getProductList();
}
