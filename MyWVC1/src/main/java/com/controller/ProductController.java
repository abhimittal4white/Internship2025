package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Product;

import javax.validation.Valid;


@Controller
@RequestMapping(value="product")
public class ProductController {
	
	@RequestMapping(path="/productForm",method = RequestMethod.GET)
	public String prepareProduct(Model model)
	{
		Product l=new Product();
		//System.out.println("In prepareLogin() method");
		model.addAttribute("myproduct",l);
		return "productForm1";
	}
	
	@RequestMapping(path="/checkProduct",method = RequestMethod.POST)
	public String validateCredentials(@Valid @ModelAttribute("myproduct") Product prod,BindingResult result,Model model)
	{
		//client side validation
		if(result.hasErrors())
		{
			System.out.println("errors");
		//	model.addAttribute("login",new Login());
			return "productForm1";
		}
		else {
			model.addAttribute("myproduct",prod);
			model.addAttribute("msg", "Successfully Logged in");
		    return "ProdSuccess";
		}
	}
	
	

}
