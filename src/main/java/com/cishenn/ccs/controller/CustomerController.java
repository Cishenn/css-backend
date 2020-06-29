package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICustomerBiz;
import com.cishenn.ccs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerBiz iCustomerBiz;

    @RequestMapping("/")
    void save(@RequestBody Customer customer){
        iCustomerBiz.save(customer);
    }

    @RequestMapping("/")
    void delete(@PathVariable Integer id){
        iCustomerBiz.delete(id);
    }

    @RequestMapping("/")
    void update(@PathVariable Integer id, @RequestBody Customer customer){
        iCustomerBiz.update(id, customer);
    }

    @RequestMapping("/")
    ResponseEntity getOne(@PathVariable Integer id){
        return new ResponseEntity(iCustomerBiz.getOne(id), HttpStatus.OK);
    }

    @RequestMapping("/")
    ResponseEntity<Map<String, List<Customer>>> getAll(){
        Map<String, List<Customer>> result=new HashMap<>();
        result.put("Customers", iCustomerBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
