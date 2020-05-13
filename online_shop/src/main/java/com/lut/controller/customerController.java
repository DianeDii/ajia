package com.lut.controller;

import com.lut.model.TbCustomer;

import com.lut.service.CustomerService;
import com.lut.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class customerController {

    @Autowired
    CustomerServiceImpl customerService;
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session){
        String username =  request.getParameter("name");
        String password = request.getParameter("pwd");
        String name = customerService.login(username,password);
        if(name ==null){
            return "redirect:/login";
        }else {
            return "redirect:/index";
        }
    }
    @RequestMapping("/register")
    public String register(@RequestParam(value = "name" ,required = false) String username,
                           @RequestParam(value = "pwd",required = false) String password,@RequestParam(value = "tel",required = false) String tel){
//        mav.setViewName("register");
        TbCustomer customer = new TbCustomer();

        customer.setCustomername(username);
        customer.setCustomerpass(password);
        customer.setCustomertel(tel);
        customerService.save(customer);

        return "register";
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
