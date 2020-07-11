package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ISessionBiz;
import com.cishenn.ccs.entity.Session;
import com.cishenn.ccs.uitls.Result;
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
    ISessionBiz sessionBiz;

    /**
     * 查询当前会话或历史会话信息
     */
    @GetMapping("/list")
    public Result getSessionList(
            @RequestParam(required = true)Integer customerServiceId,
            @RequestParam(required = false,defaultValue = "1")Integer type,
            @RequestParam(required = false,defaultValue = "1")Integer pageNum){
        List<Session> sessions = sessionBiz.getSessionList(customerServiceId,type,pageNum);

        return Result.ok(sessions);
    }

    @PostMapping("/")
    void save(@RequestBody Session session){
        sessionBiz.save(session);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        sessionBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id,@RequestBody Session session){
        sessionBiz.update(id, session);
    }

    @GetMapping("/{id}")
    ResponseEntity<Session> getOne(@PathVariable Integer id){
        return new ResponseEntity(sessionBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<Session>>> getAll(){
        Map<String, List<Session>> result = new HashMap<>();
        result.put("Sessions",sessionBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
