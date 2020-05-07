package com.lut.service;

import com.lut.model.TbCustomer;
import com.lut.model.TbReceive;

/**
 * 用户操作接口
 */
public interface CustomerService {

    TbCustomer findByName(String customername);

    TbCustomer save(TbCustomer tbCustomer);

    TbReceive addAddress(TbReceive tbReceive);

}
