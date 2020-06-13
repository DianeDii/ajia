package com.lut.controller;

import com.lut.model.TbOrder;
import com.lut.model.TbOrderdetailKey;
import com.lut.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;


    /**
     * 用户点击支付创建订单。
     * @param session
     * @param goodsList 订单商品id列表
     */
    @PostMapping("create")
    public void addOrder(HttpSession session,String goodsList){
//        TbOrder tbOrder = new TbOrder();
//        tbOrder.setOrderid(null);

//        //接受前端里的值并set
//        String username = session.getAttribute("name").toString();
//        Date orderDate = new Date();
//        Integer orderState = 0;

//        tbOrder.setCustomername(username);
//        tbOrder.setOrderdate(orderDate);
//        tbOrder.setOrderstate(orderState);
//        //计算总价格
//        tbOrder.setTotalmoney(orderService.sumGoodsPrice(goodsList));
//
//        //set订单详情
//        for (int i = 0;i < goodsList.length; i++){
//            TbOrderdetailKey tbOrderdetailKey = new TbOrderdetailKey();
//        tbOrderdetailKey.setOrderid(tbOrder.getOrderid());
//        tbOrderdetailKey.setGoodsid(goodsList[i]);
//        orderService.addOrderDetail(tbOrderdetailKey);
//        }
//        orderService.addOrder(tbOrder);
    }

    @PostMapping("del")
    public void  delOrder(Integer orderId){
        orderService.delOrder(orderId);
    }
    @PostMapping("deal")
    public void dealOrder(Integer orderId){
        orderService.dealOrder(orderId);
    }

    @RequestMapping("/toPayPage")
    public ModelAndView toPayPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payment");
        return modelAndView;
    }
    @RequestMapping("/toCartPage")
    public ModelAndView toCartPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        return  modelAndView;
    }
}
