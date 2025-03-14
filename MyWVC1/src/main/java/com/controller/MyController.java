package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/hello")
    public ModelAndView myhello() {
        String message= "Welcome and Hello to Spring MVC , Date is "+ LocalDateTime.now();
        return new ModelAndView("hello","msg",message);
    }


    @RequestMapping("/hello1")
    public ModelAndView myhello1(HttpServletRequest request) {
        String user=request.getParameter("user");
        String message= "Welcome "+user;
        return new ModelAndView("hello1","msg",message);

    }

    @RequestMapping("/hello2")
    public ModelAndView myhello2(@RequestParam("color") String color) {

        String message= "Color is  "+color;
        return new ModelAndView("hello2","msg",message);

    }


    @RequestMapping("/hello3/{eid}/{ename}/{salary}")
    public String pathData(@PathVariable("eid")int eid, @PathVariable ("ename")String ename , @PathVariable("salary")double salary , ModelMap map)
    {

        map.addAttribute("eid",eid);
        map.addAttribute("ename" ,ename);
        map.addAttribute("salary",salary);
        return "hello3";
    }

    @RequestMapping("/hello4")
    public String colormeth(@RequestHeader("User-Agent")String header , Model m){

        m.addAttribute("myheader",header);
        return "hello4";
    }



}
