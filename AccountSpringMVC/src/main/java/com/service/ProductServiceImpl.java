package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDAO;
import com.exception.NoProductException;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	@Override
	public int saveProduct(Product pd) {
		return productDAO.saveProduct(pd);
	}

	@Override
	public int updateProduct(Product pd) {
		return productDAO.updateProduct(pd);
	}

	@Override
	public int deleteProduct(Product pd) {
		return productDAO.deleteProduct(pd);
	}

	@Override
	public Product getProductById(int pid) throws NoProductException {
		Product ob = productDAO.getProductById(pid);
		if(ob==null || ob.getPid()==0)
			throw new NoProductException("No product exist with id: "+pid);
		return ob;
	}

	@Override
	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

}
