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

    String login(String customername,String password);

    int save(TbCustomer tbCustomer);

    TbReceive addAddress(TbReceive tbReceive);

}
