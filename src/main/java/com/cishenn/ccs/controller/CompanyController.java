package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICompanyBiz;
import com.cishenn.ccs.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    ICompanyBiz iCompanyBiz;

    @PostMapping("/")
    void save(@RequestBody Company company){
        iCompanyBiz.save(company);
    }

    @DeleteMapping("/{ID}")
    void delete(@PathVariable String ID){
        iCompanyBiz.delete(ID);
    }

    @PutMapping("/{ID}")
    void update(@PathVariable String ID, @RequestBody Company company){
        iCompanyBiz.update(ID, company);
    }

    @GetMapping("/{ID}")
    ResponseEntity<Company> getOne(@PathVariable String ID){
        return new ResponseEntity<>(iCompanyBiz.getOne(ID), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Company>>> getAll(){
        Map<String, List<Company>> result=new HashMap<>();
        result.put("tag", iCompanyBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}