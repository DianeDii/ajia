package com.lut.service;

import com.lut.model.TbGoods;
import com.lut.model.TbOrder;
import com.lut.model.TbOrderdetailKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    //用户产生新订单（tb_order,tb_orderdetail）
      void addOrder(TbOrder tbOrder);

    //用户产生订单详情
      void addOrderDetail(TbOrderdetailKey tbOrderdetailKey);

    //查看所有订单（tb_order）
     List<TbOrder> listOrderInfo();

    //查询一个订单内商品
      List<TbGoods> listOrderGoods(Integer orderId);


    //管理员查看所有未处理订单
     List<TbOrder> listOrderfordeal();

    /**
     *     后台处理订单
     *      orderstate =0 未处理
     *      orderstate =1  已处理
     *      orderstate =2  用户已删除
     *      传入id将 状态0 改1
     * @param orderId 订单id
     */
     void dealOrder(Integer orderId);

    //用户删除历史订单
     void delOrder(Integer orderId);

    //计算订单商品总价格
     int sumGoodsPrice(Integer[] goodsIdList);

    //查询用户所有历史订单
    List<TbOrder> listOrderByUser(String userName);
}
