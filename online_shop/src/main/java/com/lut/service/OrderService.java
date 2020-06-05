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
    public void addOrder(TbOrder tbOrder);

    //用户产生订单详情
    public  void addOrderDetail(TbOrderdetailKey tbOrderdetailKey);

    //查看所有订单（tb_order）
    public List<TbOrder> listOrderInfo();

    //查询一个订单内商品
    public  List<TbGoods> listOrderGoods(Integer orderId);


    //管理员查看所有未处理订单
    public List<TbOrder> listOrderfordeal();

    /**
     *     后台处理订单
     *      orderstate =0 未处理
     *      orderstate =1  已处理
     *      orderstate =2  用户已删除
     *      传入id将 状态0 改1
     * @param orderId 订单id
     */
    public void dealOrder(Integer orderId);

    //用户删除历史订单
    public void delOrder(Integer orderId);

    //计算订单商品总价格
    public int sumGoodsPrice(List<Integer> goodsIdList);
}
