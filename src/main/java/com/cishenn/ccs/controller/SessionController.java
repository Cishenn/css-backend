package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ISessionBiz;
import com.cishenn.ccs.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    ISessionBiz iSessionBiz;

    @PostMapping("/")
    void save(@RequestBody Session session){
        iSessionBiz.save(session);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iSessionBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id,@RequestBody Session session){
        iSessionBiz.update(id, session);
    }

    @GetMapping("/{id}")
    ResponseEntity<Session> getOne(@PathVariable Integer id){
        return new ResponseEntity(iSessionBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Session>>> getAll(){
        Map<String, List<Session>> result = new HashMap<>();
        result.put("Sessions",iSessionBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
