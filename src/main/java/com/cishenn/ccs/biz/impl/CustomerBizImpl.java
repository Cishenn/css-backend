package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ICustomerBiz;
import com.cishenn.ccs.dao.CustomerMapper;
import com.cishenn.ccs.entity.Customer;
import com.cishenn.ccs.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBizImpl implements ICustomerBiz {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void save(Customer customer){
        int result=customerMapper.save(customer);
        if(result==0){
            throw new CustomerException("Save Customer Entity Error");
        }
    }

    @Override
    public void delete(Integer id){
        int result=customerMapper.delete(id);
        if(result==0){
            throw new CustomerException("Delete Customer Entity Error");
        }
    }

    @Override
    public void update(Integer id, Customer customer){
        int result=customerMapper.update(id, customer);
        if(result==0){
            throw new CustomerException("Update Customer Entity Error");
        }
    }

    @Override
    public Customer getOne(Integer id) {
        Customer result=customerMapper.getOne(id);
        if(result==null){
            throw new CustomerException("Retrieve Customer Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<Customer> getAll() {
        return customerMapper.getAll();
    }
}
