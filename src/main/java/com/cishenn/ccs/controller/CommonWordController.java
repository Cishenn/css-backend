package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICommonWordBiz;
import com.cishenn.ccs.entity.CommonWord;
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
    void save(@RequestBody CommonWord commonWord){
        iCommonWordBiz.save(commonWord);
    }

    @DeleteMapping("/{creatorId}")
    void delete(@PathVariable Integer creatorId){

        iCommonWordBiz.delete(creatorId);
    }

    @PutMapping("/{creatorId}")
    void update(@PathVariable Integer creatorId,@RequestBody CommonWord commonWord){
        iCommonWordBiz.update(creatorId,commonWord);
    }

    @GetMapping("/{creatorId}")
    ResponseEntity<CommonWord> getOne(@PathVariable Integer creatorId){
        return new ResponseEntity<>(iCommonWordBiz.getOne(creatorId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<CommonWord>>> getAll(){
        Map<String, List<CommonWord>> result=new HashMap();
        result.put("common_word",iCommonWordBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}