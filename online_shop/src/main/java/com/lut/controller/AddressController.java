package com.lut.controller;

import com.lut.model.TbReceive;
import com.lut.service.impl.AddressServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "/address",tags = "收货地址API")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressServiceImpl addressService;
    @RequestMapping("/")
    public ModelAndView toAddressPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addressAdmin");
        return modelAndView;
    }


    @PostMapping("/add")
    public void addAddress(@RequestParam("username") String username,
                           @RequestParam("receiveName") String receiveName,
                           @RequestParam("receiveAddress") String receiveAddress,
                           @RequestParam("receiveTel") Integer receiveTel){
        TbReceive tbReceive = new TbReceive();
        tbReceive.setCustomername(username);
        tbReceive.setReceiveid(null);
        tbReceive.setReceiveaddress(receiveAddress);
        tbReceive.setReceivetel(receiveTel);
        tbReceive.setReceivename(receiveName);
        addressService.addAddress(tbReceive);
    }
    @PostMapping("/del")
    public void delAddress(@RequestParam("receiveId") Integer receiveId){
        addressService.delAddress(receiveId);
    }
    @PostMapping("/update")
    public void updateAddress(@RequestParam("receiveid") Integer receiveId,
                                   @RequestParam("receiveName") String receiveName,@RequestParam("receiveAddress") String receiveAddress,
                                   @RequestParam("receiveTel") Integer receiveTel){
        TbReceive tbReceive = addressService.showAddressById(receiveId);
//        tbReceive.setReceiveid(receiveId);
        tbReceive.setReceiveaddress(receiveAddress);
        tbReceive.setReceivetel(receiveTel);
        tbReceive.setReceivename(receiveName);
        addressService.updateAddress(tbReceive);
    }
    @PostMapping("/showAll")
    public List<TbReceive> showAll(String username,HttpSession session){
         username   = session.getAttribute("name").toString();
        return addressService.showAllAddressByCustomerName(username);
    }
    @PostMapping("/showAddDetail")
    public TbReceive showAddDetail(@RequestParam("receiveId") Integer receiveId){
        return addressService.showAddressById(receiveId);

    }
    @RequestMapping("/toupdatePage")
    public ModelAndView toupdatePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("changeAddress");
        return modelAndView;
    }
}
