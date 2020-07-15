package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICompanyBiz;
import com.cishenn.ccs.entity.Company;
import com.cishenn.ccs.utils.Result;
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

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        iCompanyBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable String id, @RequestBody Company company){
        iCompanyBiz.update(id, company);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        return Result.ok(iCompanyBiz.getOne(id));
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Company>>> getAll(){
        Map<String, List<Company>> result=new HashMap<>();
        result.put("tag", iCompanyBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}