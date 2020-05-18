package com.lut.service;

import com.lut.model.TbCustomer;
import com.lut.model.TbReceive;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作接口
 */
@Service
public interface CustomerService {

    TbCustomer login(String customername);

    void save(TbCustomer tbCustomer);

    TbReceive addAddress(TbReceive tbReceive);

    void changeTel(TbCustomer user,String tel);

}
