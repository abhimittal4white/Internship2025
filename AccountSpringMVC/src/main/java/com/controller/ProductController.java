package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Product;
import com.exception.NoProductException;
import com.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("showallproduct")
	public String showAllProduct(Model m)
	{
		System.out.println("Listing all products");
		List<Product> alist=productService.getProductList();
		System.out.println(alist);
		m.addAttribute("aslist", alist);
		return "ListAllProduct";
	}
/*
	@RequestMapping("productform")
	public String getProductForm(Model m)
	{
		m.addAttribute("prod", new Product());
		return "ProdForm";
	}

   @RequestMapping(value="/save1",method = RequestMethod.POST)    
    public String save(@Valid @ModelAttribute("prod") Product prod , BindingResult result){   
	   	if(result.hasErrors()) {
	   		return "ProdForm";
	   	}
	   
        productService.saveProduct(prod)    ;
        return "redirect:/showallproduct";//will redirect to viewemp request mapping    
    }
 */  
   /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    /*
    @RequestMapping(value="/editprod/{id}")    
    public String edit(@PathVariable("id") int id, Model m) throws NoProductException{    
    	System.out.println("Before edit form");
        Product pd=productService.getProductById(id);    
        m.addAttribute("prod",pd);  
        return "ProdEditForm";   
    }    
   */ 
    /* It updates model object. */    /*
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@Valid @ModelAttribute("prod") Product prod , BindingResult result){    
     	if(result.hasErrors()) {
	   		return "ProdEditForm";
	   	}
     	else {
     		System.out.println("Update in controller");
     		System.out.println(prod);
     		productService.updateProduct(prod);
     		return "redirect:/showallproduct";   
     	}
    }    
    */
    /* It deletes record for the given id in URL and redirects to /viewemp */    
 /*   @RequestMapping(value="/deleteprod/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id) throws NoProductException{
    	Product pd= productService.getProductById(id);
        productService.deleteProduct(pd);
        return "redirect:/showallproduct";    
    }     
    
    @GetMapping("searchmyproduct")
    public String searchmyproduct() {
    	return "SearchProduct";
    }
    
    @PostMapping("searchbyid")
    public String searchProduct(@RequestParam("searchprod") int pid , Model model) throws NoProductException {
    	Product pd= productService.getProductById(pid);
    	model.addAttribute("myprod",pd);
    	return "DisplayProduct";
    	
    }
*/
}
