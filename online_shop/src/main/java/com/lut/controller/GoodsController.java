package com.lut.controller;

import com.lut.service.impl.GoodsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Api(value = "/goods",tags = "商品API")
@RequestMapping("/goods")
@RestController
public class GoodsController {
    @Autowired
    GoodsServiceImpl goodsService;

    @PostMapping("/listAll")
    public ModelAndView listAllGoods(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(goodsService.showGoods());
        return  modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(HttpServletRequest request){
        //获取前台搜索框输入的数据
        String search = request.getParameter("search");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(goodsService.showGoodsByField(search));
        return modelAndView;
    }
}
