package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginUser;

import javax.validation.Valid;


@Controller
@RequestMapping(value="login")
public class LoginController {
	
	@RequestMapping(path="/loginform",method = RequestMethod.GET)
	public String prepareLogin(Model model)
	{
		LoginUser l=new LoginUser();
		l.setUserName("Manjiri");
		//System.out.println("In prepareLogin() method");
		model.addAttribute("mylogin",l);
		return "login";
	}
	
	@RequestMapping(path="/checkLogin",method = RequestMethod.POST)
	public String validateCredentials(@Valid @ModelAttribute("mylogin") LoginUser login,BindingResult result,Model model)
	{
		//client side validation
		if(result.hasErrors())
		{
			System.out.println("errors");
		//	model.addAttribute("login",new Login());
			return "login";
		}
		else {
			System.out.println("No errors");
		}
		
		if(login.getUserName().equals("Manjiri") && login.getPassword().equals("nls"))
		{
			model.addAttribute("mylogin",login);
			model.addAttribute("msg", "Successfully Logged in");
		    return "loginsuccess";
		}
		else
			return "loginerror";
	}
	
	

}
