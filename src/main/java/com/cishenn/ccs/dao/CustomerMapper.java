package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int save(Customer customer);

    int delete(Integer id);

    int update(Integer id, Customer customer);

    Customer getOne(Integer id);

    List<Customer> getAll();
}
