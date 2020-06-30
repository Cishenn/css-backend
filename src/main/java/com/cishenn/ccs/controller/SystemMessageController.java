package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ISystemMessageBiz;
import com.cishenn.ccs.entity.SystemMessage;
import com.cishenn.ccs.entity.VisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/systemmessage")
public class SystemMessageController {
    @Autowired
    ISystemMessageBiz iSystemMessageBiz;

    @PostMapping("/")
    void save(@RequestBody SystemMessage systemMessage){
        iSystemMessageBiz.save(systemMessage);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iSystemMessageBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id,@RequestBody SystemMessage systemMessage){
        iSystemMessageBiz.update(id,systemMessage);
    }

    @GetMapping("/{id}")
    ResponseEntity<SystemMessage> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(iSystemMessageBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<SystemMessage>>> getAll(){
        Map<String, List<SystemMessage>> result=new HashMap();
//        put函数中的字符串不知道写法是否正确
        result.put("systemmessage",iSystemMessageBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
