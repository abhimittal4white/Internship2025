package com.service;

import java.util.List;

import com.data.Product;
import com.exception.NoProductException;

public interface ProductService {
	public int saveProduct(Product pd);
	public int updateProdName(Product pd, String name);
	public int updateProdPrice(Product pd, double price);
	public int deleteProduct(Product pd);
	public Product getProductById(int pid) throws NoProductException;
	public List<Product> getProductList();
	
}
