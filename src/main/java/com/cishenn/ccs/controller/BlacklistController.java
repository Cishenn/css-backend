package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.biz.ICustomerBiz;
import com.cishenn.ccs.entity.Blacklist;
import com.cishenn.ccs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blacklist")
public class BlacklistController {
    @Autowired
    IBlacklistBiz iBlacklistBiz;

    @PostMapping("/")
    void save(@RequestBody Blacklist blacklist) {
        iBlacklistBiz.save(blacklist);
    }

    @DeleteMapping("/{customerId}")
    void delete(@PathVariable Integer customerId) {
        iBlacklistBiz.delete(customerId);
    }

    @GetMapping("/{customerId}")
    ResponseEntity getOne(@PathVariable Integer customerId) {
        return new ResponseEntity(iBlacklistBiz.getOne(customerId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Blacklist>>> getAll() {
        Map<String, List<Blacklist>> result = new HashMap<>();
        result.put("Blacklist", iBlacklistBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
