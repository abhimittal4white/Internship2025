package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.data.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveProduct(Product pd) {
		String sql="insert into product values(?,?,?)";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>()
				{

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
								ps.setInt(1, pd.getPid());
								ps.setString(2, pd.getPname());
								ps.setDouble(3, pd.getPrice());
						return ps.executeUpdate();
					}
					
				});
	}

	@Override
	public int updateProductName(Product pd) {
		String sql = "update product set pname=? where pid=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() 
		{

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
						ps.setString(1, pd.getPname());
						ps.setInt(2, pd.getPid());				
						return ps.executeUpdate();
			}
			
		});
	}
	
	@Override
	public int updateProductPrice(Product pd) {
		String sql = "update product set price=? where pid=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() 
		{
			
			@Override
			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setDouble(1, pd.getPrice());
				ps.setInt(2, pd.getPid());				
				return ps.executeUpdate();
			}
			
		});
	}

	@Override
	public int deleteProduct(Product pd) {
		String sql="delete from product where pid=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() 
		{

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
						ps.setInt(1, pd.getPid());				
						return ps.executeUpdate();
			}
		});
	}

	@Override
	public Product getProductById(int pid) {
		return (Product) jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid} , 
				new RowMapper<Product>()
				{
					@Override
					public Product mapRow(ResultSet rs, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						Product pd=new Product();
						pd.setPid(rs.getInt("pid"));
						pd.setPname(rs.getString("pname"));
						pd.setPrice(rs.getDouble("price"));
//						System.out.println("Retrieved Products "+pd);
						return pd;
					}
					
				});	
	}

	@Override
	public List<Product> getProductList() {
		return jdbcTemplate.query("select * from product", 

				new RowMapper<Product>()
				{
					@Override
					public Product mapRow(ResultSet rs, int arg1) 
							throws SQLException {
							Product pd=new Product();
							pd.setPid(rs.getInt("pid"));
							pd.setPname(rs.getString("pname"));
							pd.setPrice(rs.getDouble("price"));
						return pd;
					}	
				});
	}

	
	
}
