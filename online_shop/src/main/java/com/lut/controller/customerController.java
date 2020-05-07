package com.lut.controller;

import com.lut.model.TbCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lut.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;

@Controller
public class customerController {

    @RequestMapping("/login")
    public String login(){
        return "web/login";
    }



}
