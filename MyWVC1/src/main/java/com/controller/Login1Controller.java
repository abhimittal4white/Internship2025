package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login1Controller {

    @RequestMapping(path="form1",method= RequestMethod.GET)
    public String getForm1() {
        return "login1";
    }

    @RequestMapping(path = "login1",method = RequestMethod.POST)
    public String form1post(@RequestParam("username") String uname, @RequestParam("pass")String pass , Model m) {
        if(uname.equals("manjiri") && pass.equals("abc123")) {
            m.addAttribute("user",uname) ;
            return "success";
        }
        else {
            return "error";
        }
    }
}
