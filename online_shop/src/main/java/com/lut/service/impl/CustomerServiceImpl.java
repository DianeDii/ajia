package com.lut.service.impl;

import com.lut.dao.TbCustomerMapper;
import com.lut.model.TbCustomer;
import com.lut.model.TbReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lut.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    TbCustomerMapper tbCustomerMapper;
    @Override
    public TbCustomer login(String customername) {
//这里返回为空到controller处理
       return tbCustomerMapper.selectByPrimaryKey(customername);
    }

    @Override
    public void save(TbCustomer tbCustomer) {
        tbCustomerMapper.insert(tbCustomer);
    }

    @Override
    public TbReceive addAddress(TbReceive tbReceive) {
        return null;
    }

    @Override
    public void changeTel(TbCustomer user,String tel) {

        user.setCustomertel(tel);
        tbCustomerMapper.updateByPrimaryKey(user);
    }
}
