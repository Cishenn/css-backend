package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Customer;

import java.util.List;

public interface ICustomerBiz {
    void save(Customer customer);

    void delete(Integer id);

    void update(Integer id, Customer customer);

    Customer getOne(Integer id);

    List<Customer> getAll();


}
