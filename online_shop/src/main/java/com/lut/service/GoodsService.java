package com.lut.service;

import com.lut.model.TbGoods;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GoodsService {
    //主页显示所有商品
    List<TbGoods> showGoods();

    //字段搜索显示相应商品
    List<TbGoods> showGoodsByField(String goodName);

    //凭主键获取商品
    TbGoods getGoodsDetail(Integer id);

    //增加商品
    void addGoods(TbGoods tbGoods);

    //删除商品
    void delGoods(Integer goodsId);

    //更新商品
    int updateGoods(TbGoods tbGoods);
}
