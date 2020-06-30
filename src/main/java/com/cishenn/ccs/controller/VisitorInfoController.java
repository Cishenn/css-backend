package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IVisitorInfoBiz;
import com.cishenn.ccs.entity.VisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/visitorinfo")
public class VisitorInfoController {
    @Autowired
    IVisitorInfoBiz iVisitorInfoBiz;

    @PostMapping("/")
    void save(@RequestBody VisitorInfo visitorInfo){
        iVisitorInfoBiz.save(visitorInfo);
    }

    @DeleteMapping("/{ip}")
    void delete(@PathVariable String ip){
        iVisitorInfoBiz.delete(ip);
    }

    @PutMapping("/{ip}")
    void update(@PathVariable String ip,@RequestBody VisitorInfo visitorInfo){
        iVisitorInfoBiz.update(ip,visitorInfo);
    }

    @GetMapping("/{ip}")
    ResponseEntity<VisitorInfo> getOne(@PathVariable String ip){
        return new ResponseEntity<>(iVisitorInfoBiz.getOne(ip), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<VisitorInfo>>> getAll(){
        Map<String, List<VisitorInfo>> result=new HashMap();
        result.put("visitorinfo",iVisitorInfoBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
