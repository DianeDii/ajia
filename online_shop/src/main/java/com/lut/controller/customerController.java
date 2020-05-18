package com.lut.controller;

import com.alibaba.fastjson.JSON;
import com.lut.model.TbCustomer;

import com.lut.service.CustomerService;
import com.lut.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class customerController {

    @Autowired
    CustomerServiceImpl customerService;
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }
    @RequestMapping(value = "/loginPage")
    public String login(HttpServletRequest request, HttpSession session){
        String username =  request.getParameter("name");
        String password = request.getParameter("pwd");
        String name = customerService.login(username).getCustomername();
        String pwd = customerService.login(username).getCustomerpass();

        if(password.equals(pwd) && username.equals(name)){
            session.setAttribute("name",username);
            return "redirect:/index";
        }else {
            return "redirect:/login";

        }

    }
    @RequestMapping("/registerPage")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        TbCustomer customer = new TbCustomer();

        customer.setCustomername(username);
        customer.setCustomerpass(password);
        customer.setCustomertel(tel);
        customerService.save(customer);

        return "login";
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/myInfo")
    public ModelAndView showInfo(HttpSession session){
        String username  = session.getAttribute("name").toString();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myInfo",customerService.login(username));

        List<String> myInfo = new ArrayList<>();
        myInfo.add(customerService.login(username).getCustomername());
        myInfo.add(customerService.login(username).getCustomerpass());
        myInfo.add(customerService.login(username).getCustomertel());
        //List转json
        String info = JSON.toJSONString(myInfo);
        System.out.println(info);
//        modelAndView.addObject("myInfo",info);

        modelAndView.setViewName("myInfo");
        return modelAndView;
    }
    @RequestMapping("/address")
    public ModelAndView manAddress(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "/changeTelPage")
    public String changeTel() {
        return "changepwd";
    }
    @RequestMapping("/changeTel")
    public String changeTel(HttpSession session,HttpServletRequest request){
        TbCustomer user = customerService.login(session.getAttribute("name").toString());
       String tel = request.getParameter("tel");
        customerService.changeTel(user,tel);
        return "redirect:/myInfo";
    }

}
