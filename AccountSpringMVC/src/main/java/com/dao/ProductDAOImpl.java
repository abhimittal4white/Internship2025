package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveProduct(Product pd) {
		String sql="insert into product values("+pd.getPid()+",'"+pd.getPname()+"',"+pd.getPrice()+")";
		int i=jdbcTemplate.update(sql);
		return i;
	}

	@Override
	public int updateProduct(Product pd) {
		String sql="update product set pname='"+pd.getPname()+"',price="+pd.getPrice()+" where pid="+pd.getPid();
		int i=jdbcTemplate.update(sql);
		return i;
	}

	@Override
	public int deleteProduct(Product pd) {
		String sql="delete from product  where pid="+pd.getPid()+"";
		int i=jdbcTemplate.update(sql);
		return i;
	}

	@Override
	public Product getProductById(int pid) {
		return jdbcTemplate.query("select * from product where pid="+pid, 
				new ResultSetExtractor<Product>()
				{

		//			@Override
					public Product extractData(ResultSet rs) 
							throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						System.out.println("Rtrieving Product...");
						Product ob=new Product();
						if(rs.next())
						{
						ob.setPid(rs.getInt("pid"));
						ob.setPname(rs.getString("pname"));
						ob.setPrice(rs.getDouble("price"));
						}
						System.out.println("Rtrieved Product "+ob);
						return ob;
					}
				});	
	}

	@Override
	public List<Product> getProductList() {
		return jdbcTemplate.query("select * from product", 
				new ResultSetExtractor<List<Product>>()
				{

					@Override
					public List<Product> extractData(ResultSet rs) 
					throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						List<Product> alist=new ArrayList<Product>();
						while(rs.next())
						{
							Product ob=new Product();
							ob.setPid(rs.getInt("pid"));
							ob.setPname(rs.getString("pname"));
							ob.setPrice(rs.getDouble("price"));
							alist.add(ob);
							System.out.println(ob);
						}
						return alist;
					}	
				});
	}
	
	
}
