package com.lut.service.impl;

import com.lut.dao.TbGoodstypeMapper;
import com.lut.dao.TbReceiveMapper;
import com.lut.model.TbReceive;
import com.lut.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    TbReceiveMapper tbReceiveMapper;
    @Override
    public void addAddress(TbReceive tbReceive) {
        tbReceiveMapper.insert(tbReceive);
    }

    @Override
    public void delAddress(Integer id) {
        tbReceiveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbReceive> showAllAddressByCustomerName(String username) {
        return tbReceiveMapper.showAll(username);
    }

    @Override
    public TbReceive showAddressById(Integer id) {
        return tbReceiveMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAddress(TbReceive tbReceive) {
        tbReceiveMapper.updateByPrimaryKey(tbReceive);
    }
}
