package com.lut.controller;

import com.lut.model.TbGoods;
import com.lut.service.impl.GoodsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.models.Model;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "/goods",tags = "商品API")
@RequestMapping("/goods")
@RestController
public class GoodsController {
    @Autowired
    GoodsServiceImpl goodsService;

    @PostMapping("/listAll")
    public List<TbGoods> listAllGoods(){

        return  goodsService.showGoods();
    }
    @PostMapping("/search")
    public List<TbGoods> search(HttpServletRequest request){
        //获取前台搜索框输入的数据
        String search = request.getParameter("input");
        return goodsService.showGoodsByField(search);
    }
//    @GetMapping("/{goodsId}")
//    public ModelAndView GoodsDetail(@PathVariable("goodsId") Integer id, HttpSession session){
//        ModelAndView modelAndView = new ModelAndView();
//        session.setAttribute("goodsid",id);
//        modelAndView.addObject(goodsService.getGoodsDetail(id));
//        return modelAndView;
//
//    }
    @GetMapping("/{goodsId}")
    public TbGoods GoodsDetail(@PathVariable("goodsId") Integer id){
        return goodsService.getGoodsDetail(id);
    }
    @RequestMapping("/detail")
    public ModelAndView detailPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsDetail");
        return modelAndView;
    }
    @RequestMapping("/404")
    public ModelAndView noFoundPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        return modelAndView;
    }
}
