package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.INoticeBiz;
import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    INoticeBiz iNoticeBiz;

    @PostMapping("/")
    void save(@RequestBody Notice notice){
        iNoticeBiz.save(notice);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iNoticeBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id, @RequestBody Notice notice){
        iNoticeBiz.update(id, notice);
    }

    @GetMapping("/{id}/")
    ResponseEntity getOne(@PathVariable Integer id){
        return new ResponseEntity(iNoticeBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    @CrossOrigin
    public Result getAll(){
        Map<String, List<Notice>> result=new HashMap<>();
        result.put("Notices", iNoticeBiz.getAll());
        return Result.ok(result);
    }
}
