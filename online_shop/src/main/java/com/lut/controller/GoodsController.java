package com.lut.controller;

import com.lut.model.TbGoods;
import com.lut.service.impl.GoodsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    @PostMapping("/addGoods")
    public void addGoods(HttpServletRequest request){
        String goodsName = request.getParameter("goodsName");
        Integer goodstypeid = Integer.parseInt(request.getParameter("goodstypeid"));
        String goodsdescript = request.getParameter("goodsdescript");
        Integer goodsunitprice = Integer.parseInt(request.getParameter("goodsunitprice"));
        String goodsimagename = request.getParameter("goodsimagename");
        Integer sellcount = Integer.parseInt(request.getParameter("sellcount"));

        TbGoods tbGoods = new TbGoods();
        tbGoods.setGoodsname(goodsName);
        tbGoods.setGoodsdescript(goodsdescript);
        tbGoods.setGoodsid(null);
        tbGoods.setGoodsimagename(goodsimagename);
        tbGoods.setGoodstypeid(goodstypeid);
        tbGoods.setGoodsunitprice(goodsunitprice);
        tbGoods.setSellcount(sellcount);
        goodsService.addGoods(tbGoods);
    }
    @PostMapping("/delete")
    public void delGoods(Integer goodsId){
        goodsService.delGoods(goodsId);
    }
    @PostMapping("/update")
    public void updateGoods(@RequestParam("id") Integer goodsid,@RequestParam("goodsName") String goodsname,
                            @RequestParam("goodstypeid") Integer goodstypeid,
                            @RequestParam("goodsdescript") String goodsdescript,
                            @RequestParam("goodsunitprice") Integer goodsunitprice,
                            @RequestParam("goodsimagename") String goodsimagename){
        Integer data = goodsid;

        TbGoods tbGoods = goodsService.getGoodsDetail(data);

        tbGoods.setGoodsname(goodsname);
        tbGoods.setGoodsdescript(goodsdescript);
        tbGoods.setGoodsid(data);
        tbGoods.setGoodsimagename(goodsimagename);
        tbGoods.setGoodstypeid(goodstypeid);
        tbGoods.setGoodsunitprice(goodsunitprice);
        goodsService.updateGoods(tbGoods);
    }
    @PostMapping("/updateNum")
    public void updateGoodsNum(HttpServletRequest request){
        Integer sellcount = Integer.parseInt(request.getParameter("sellcount"));
        TbGoods tbGoods = new TbGoods();
        tbGoods.setSellcount(sellcount);
        goodsService.updateGoods(tbGoods);
    }
    @PostMapping("/search")
    public List<TbGoods> search(HttpServletRequest request){
        //获取前台搜索框输入的数据
        String search = request.getParameter("input");
        return goodsService.showGoodsByField(search);
    }

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
    @RequestMapping("/toupdate")
    public ModelAndView updateGoodsPage(){
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
    @RequestMapping("/manGoods")
    public ModelAndView changeGoods(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/member-list");
        return modelAndView;
    }
    @RequestMapping("/editGoods")
    public ModelAndView editGoods(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/member-edit");
        return modelAndView;
    }
}
