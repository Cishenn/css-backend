package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICustomerBiz;
import com.cishenn.ccs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerBiz iCustomerBiz;

    @PostMapping("/")
    void save(@RequestBody Customer customer){
        iCustomerBiz.save(customer);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iCustomerBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id, @RequestBody Customer customer){
        iCustomerBiz.update(id, customer);
    }

    @GetMapping("/{id}")
    ResponseEntity getOne(@PathVariable Integer id){
        return new ResponseEntity(iCustomerBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Customer>>> getAll(){
        Map<String, List<Customer>> result=new HashMap<>();
        result.put("Customers", iCustomerBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
