package com.lut.service;

import com.lut.model.TbReceive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
     void addAddress(TbReceive tbReceive);

     void delAddress(Integer id);

     List<TbReceive> showAllAddressByCustomerName(String username);

     TbReceive showAddressById(Integer id);

     void updateAddress(TbReceive tbReceive);
}
