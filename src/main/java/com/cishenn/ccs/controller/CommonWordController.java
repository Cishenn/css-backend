package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.ICommonWordBiz;
import com.cishenn.ccs.entity.CommonWord;
import com.cishenn.ccs.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/commonword")
@CrossOrigin
public class CommonWordController {
    @Autowired
    ICommonWordBiz iCommonWordBiz;

    @PostMapping("/inser")
    int save(@RequestBody CommonWord commonWord){
        iCommonWordBiz.save(commonWord);
        return 0;
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

    @GetMapping("/onelib")
    ResponseEntity<Map<String, List<CommonWord>>> getOneType(String lib){
        Map<String, List<CommonWord>> result=new HashMap();
        result.put("common_word",iCommonWordBiz.getOneLib(lib));
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/")
    public Result getAll(){
        Map<String, List<CommonWord>> result=new HashMap();
        result.put("common_word",iCommonWordBiz.getAll());
        return Result.ok(result);
    }

}
