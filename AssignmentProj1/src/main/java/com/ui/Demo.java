package com.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.data.Product;
import com.exception.NoProductException;
import com.service.ProductService;

public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(com.config.AppConfig.class);
		ProductService service=(ProductService)context.getBean("productService");
		
		int comm=0;
		do {
			System.out.println("1. Get Product by ID");
			System.out.println("2. Get All Products");
			System.out.println("3. Add a Product");
			System.out.println("4. Update a Product");
			System.out.println("5. Remove a Product");
			System.out.println("6. Exit");
			System.out.println("Enter a command: ");
			Scanner sc = new Scanner(System.in);
			comm = sc.nextInt();
			
			switch(comm) {
			case 1: getProduct(service);
					break;
			case 2: getAllProduct(service);
					break;
			case 3: addProduct(service);
					break;
			case 4: try {
						updateProdNamePrice(service);
					} catch (NoProductException e) {
						e.printStackTrace();
					}
					break;
			case 5: deleteProduct(service);
					break;
			case 6: return;
			}
			
		}while(comm<6);
		
		
		
//		System.out.println("-------------------");
//		List<Product> pdList=service.getProductList();
//		for(Product ob:pdList)
//		System.out.println(ob);
//		
//		System.out.println("-------------------");
		
		System.out.println("done");
	}
	
	public static void addProduct(ProductService service)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product ID ");
		int pid=sc.nextInt();
		
		
		System.out.println("Enter Product name");
		String name=sc.next();
		System.out.println("Enter Price");
		double price=sc.nextDouble();
		Product pd=new Product(pid, name, price);
		int is=service.saveProduct(pd);
		System.out.println(pd);
		sc.nextLine();
		System.out.println(is+"Product inserted");
	}
	
	public static void deleteProduct(ProductService service) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product ID ");
		int pid=sc.nextInt();
		
		Product pd;
		try {
			pd = service.getProductById(pid);
			int is = service.deleteProduct(pd);
			System.out.println("Deleted "+ pd);
			System.out.println(is+" Product deleted");
			
		} catch (NoProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getProduct(ProductService service) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product ID ");
		int pid=sc.nextInt();
		
		Product pd;
		try {
			pd = service.getProductById(pid);
			System.out.println(pd);
			
		} catch (NoProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllProduct(ProductService service)
	{
		List<Product> pdList= service.getProductList();
		System.out.println("===================");
		for(Product pd : pdList) {
			System.out.println(pd);
		}
		System.out.println("===================");
	}
	
	public static void updateProdNamePrice(ProductService service) throws NoProductException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product ID ");
		//sc.nextLine();
		int pid=sc.nextInt();
		Product pd=service.getProductById(pid);
		System.out.println("Product before "+pd);
		System.out.println("Enter 1 to update Product Name\nEnter 2 update Price");
		int option=sc.nextInt();
		
		sc.nextLine();
		
		switch (option) {
		case 1:
			try
			{
				System.out.println("Enter new Product Name: ");
				String name =sc.next();
				int up=service.updateProdName(pd, name);
				System.out.println(up+" records updated");
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Update was not successful");
				System.out.println(e);
			}
			break;

		case 2:
			try
			{
				System.out.println("Enter new Product Price: ");
				double price =sc.nextDouble();
				int up=service.updateProdPrice(pd, price);
				System.out.println(up+" records updated");
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Update was not successful");
				System.out.println(e);
			}
			break;
			default:
				System.out.println("Invalid option. No Action");
		}
		pd=service.getProductById(pid);
		System.out.println("Product after update "+pd);
//		sc.close();
	}

}
