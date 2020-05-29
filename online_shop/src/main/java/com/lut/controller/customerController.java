package com.lut.controller;

import com.lut.model.TbCustomer;
import com.lut.service.impl.CustomerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//swagger Api待完成
@Api(value = "/user",tags = "用户操作API")
@RequestMapping("/user")
@RestController
public class customerController {

    @Autowired
    CustomerServiceImpl customerService;
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/changeTelPage")
    public ModelAndView changeTel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("changeTel");
        return modelAndView;
    }

    @ApiOperation(value = "/login",tags = "用户登录逻辑")
    @PostMapping(value = "/loginPage")
    public ModelAndView login(HttpServletRequest request, HttpSession session){
        String username =  request.getParameter("name");
        String password = request.getParameter("pwd");
        String name = customerService.login(username).getCustomername();
        String pwd = customerService.login(username).getCustomerpass();
        Integer power = customerService.login(username).getPower();
        ModelAndView modelAndView = new ModelAndView();

        if(password.equals(pwd) && username.equals(name)){
            session.setAttribute("name",username);
            if (power == 1 ){
                modelAndView.setViewName("index");
            }else if (power ==2){
                modelAndView.setViewName("admin/index");
            }

        }else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @PostMapping("/registerPage")
    public ModelAndView register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        TbCustomer customer = new TbCustomer();
        ModelAndView modelAndView = new ModelAndView();
        customer.setCustomername(username);
        customer.setCustomerpass(password);
        customer.setCustomertel(tel);
        customerService.save(customer);
        modelAndView.setViewName("login");

        return modelAndView;
    }


    @GetMapping("/myInfo")
    public ModelAndView showInfo(HttpSession session){
        String username  = session.getAttribute("name").toString();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myInfo",customerService.login(username));

        List<String> myInfo = new ArrayList<>();
        myInfo.add(customerService.login(username).getCustomername());
        myInfo.add(customerService.login(username).getCustomerpass());
        myInfo.add(customerService.login(username).getCustomertel());
        modelAndView.setViewName("myInfo");
        return modelAndView;
    }
//    施工中...
    @RequestMapping("/address")
    public ModelAndView manAddress(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @PostMapping("/changeTel")
    public ModelAndView changeTel(HttpSession session,HttpServletRequest request){
        TbCustomer user = customerService.login(session.getAttribute("name").toString());
       String tel = request.getParameter("tel");
        customerService.changeTel(user,tel);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("myInfo");
        return modelAndView;
    }

//    管理员方法
//    页面还没好
    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/welcome");
        return modelAndView;
    }
}
