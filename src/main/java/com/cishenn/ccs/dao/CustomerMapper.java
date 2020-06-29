package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    int save(Customer customer);

    int delete(Integer id);

    int update(Integer id, Customer customer);

    Customer getOne(Integer id);

    List<Customer> getAll();
}
