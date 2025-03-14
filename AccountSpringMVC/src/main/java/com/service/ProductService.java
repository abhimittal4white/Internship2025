package com.service;

import java.util.List;

import com.bean.Product;
import com.exception.NoProductException;

public interface ProductService {
	public int saveProduct(Product pd);
	public int updateProduct(Product ac);
	public int deleteProduct(Product ac);
	public Product getProductById(int pid) throws NoProductException ;
	public List<Product> getProductList();
}
