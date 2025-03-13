package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.data.Product;
import com.exception.NoProductException;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int saveProduct(Product pd) {
		return productDAO.saveProduct(pd);
	}

	@Override
	public int updateProdName(Product pd, String name) {
		pd.setPname(name);
		return productDAO.updateProductName(pd);
	}

	@Override
	public int updateProdPrice(Product pd, double price) {
		pd.setPrice(price);
		return productDAO.updateProductPrice(pd);
	}

	@Override
	public int deleteProduct(Product pd) {
		return productDAO.deleteProduct(pd);
	}

	@Override
	public Product getProductById(int pid) throws NoProductException {
		Product pd = productDAO.getProductById(pid);
		if(pd==null) {
			throw new NoProductException("No such product exist with pid = "+pid);
		}
		return pd;
	}

	@Override
	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

}
