package com.lut.service.impl;

import com.lut.dao.TbGoodsMapper;
import com.lut.dao.TbOrderMapper;
import com.lut.dao.TbOrderdetailMapper;
import com.lut.model.TbGoods;
import com.lut.model.TbOrder;
import com.lut.model.TbOrderdetailKey;
import com.lut.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    TbOrderMapper tbOrderMapper;
    @Autowired
    TbOrderdetailMapper tbOrderdetailMapper;
    @Autowired
    TbGoodsMapper tbGoodsMapper;
//    @Override
//    public void addOrderDetail(TbOrderdetailKey tbOrderdetailKey) {
//
//        tbOrderdetailMapper.insert(tbOrderdetailKey);
//    }

    @Override
    public void addOrder(TbOrder tbOrder) {

        tbOrderMapper.insert(tbOrder);

    }

    @Override
    public  void addOrderDetail(TbOrderdetailKey tbOrderdetailKey){
        tbOrderdetailMapper.insert(tbOrderdetailKey);
    }
    @Override
    public List<TbOrder> listOrderInfo() {
        return tbOrderMapper.showAll();
    }

    @Override
    public List<TbGoods> listOrderGoods(Integer orderId) {
         List<Integer> goodsId = tbOrderdetailMapper.findGoodsByOrderId(orderId);
         List<TbGoods> OrderList = new ArrayList<>();
         for (int i = 0; i < goodsId.size(); i++){
             OrderList.add(tbGoodsMapper.selectByPrimaryKey(goodsId.get(i)));
         }
        return OrderList;
    }

    /**
     * @param goodsIdList 订单商品Id列表
     * @return sum 订单总价格
     */
    @Override
    public int sumGoodsPrice(List<Integer> goodsIdList) {
        int sum = 0;
        for (int i =0 ; i <goodsIdList.size(); i ++){
           sum += tbGoodsMapper.getGoodsPriceByGoodsId(goodsIdList.get(i));
        }
        return sum;
    }

    @Override
    public List<TbOrder> listOrderfordeal() {
        return tbOrderMapper.showAllfordeal();
    }

    @Override
    public void dealOrder(Integer orderId) {
        tbOrderMapper.dealOrder(orderId);
    }

    @Override
    public void delOrder(Integer orderId) {
        tbOrderMapper.delOrder(orderId);
    }


}
