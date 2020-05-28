package com.lut.service.impl;

import com.lut.dao.TbGoodsMapper;
import com.lut.model.TbGoods;
import com.lut.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    TbGoodsMapper tbGoodsMapper;
    @Override
    public List<TbGoods> showGoods() {
        return tbGoodsMapper.findAllGoods();
    }

    @Override
    public List<TbGoods> showGoodsByField(String goodName) {
        return tbGoodsMapper.findGoodsByFiled(goodName);
    }

    @Override
    public TbGoods getGoodsDetail(Integer id) {
        return tbGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addGoods(TbGoods tbGoods) {
        tbGoodsMapper.insert(tbGoods);
    }

    @Override
    public void delGoods(Integer goodsId) {
        tbGoodsMapper.deleteByPrimaryKey(goodsId);
    }

    @Override
    public int updateGoods(TbGoods tbGoods) {
        return tbGoodsMapper.updateByPrimaryKey(tbGoods);
    }
}

