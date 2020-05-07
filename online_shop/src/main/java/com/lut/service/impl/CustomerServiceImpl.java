package com.lut.service.impl;

import com.lut.dao.TbCustomerMapper;
import com.lut.model.TbCustomer;
import com.lut.model.TbReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lut.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    TbCustomerMapper tbCustomerMapper;
    @Override
    public TbCustomer findByName(String customername) {
        return tbCustomerMapper.selectByPrimaryKey(customername);
    }

    @Override
    public TbCustomer save(TbCustomer tbCustomer) {
        return tbCustomer;
    }

    @Override
    public TbReceive addAddress(TbReceive tbReceive) {
        return null;
    }
}
