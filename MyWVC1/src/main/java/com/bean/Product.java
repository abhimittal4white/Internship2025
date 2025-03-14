package com.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {

//	@Size (min=3, max=3, message = "Pid should be of 3 characters")
	@Min(value=100L, message = "Pid should be of 3 characters")
	@Max(value=999L, message = "Pid should be of 3 characters")
	private int pid;

    @NotEmpty(message = "name can not be empty")
    @Size (min=3,message = "Name should be of atleast 3 characters")
    private String pname;

//    @NotEmpty(message = "Price can not be empty")
    private double price;

    public Product() {
    }

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
}
