package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICommonWordBiz;
import com.cishenn.ccs.entity.Servicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commonword")
public class CommonWordController {
    @Autowired
    ICommonWordBiz iCommonWordBiz;

    @PostMapping("/")
    void save(@RequestBody Servicer servicer){
        iCommonWordBiz.save(servicer);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iCommonWordBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id,@RequestBody Servicer servicer){
        iCommonWordBiz.update(id,servicer);
    }

    @GetMapping("/{id}")
    ResponseEntity<Servicer> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(iCommonWordBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Servicer>>> getAll(){
        Map<String, List<Servicer>> result=new HashMap();
        result.put("servicers",iCommonWordBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
