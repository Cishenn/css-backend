package com.cishenn.ccs.controller;
import com.cishenn.ccs.biz.ITagBiz;
import com.cishenn.ccs.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    ITagBiz iTagBiz;

    @PostMapping("/")
    void save(@RequestBody Tag tag){
        iTagBiz.save(tag);
    }

    @DeleteMapping("/{creatorId}")
    void delete(@PathVariable Integer creatorId){
        iTagBiz.delete(creatorId);
    }

    @PutMapping("/{creatorId}")
    void update(@PathVariable Integer creatorId,@RequestBody Tag tag){
        iTagBiz.update(creatorId, tag);
    }

    @GetMapping("/{creatorId}")
    ResponseEntity<Tag> getOne(@PathVariable Integer creatorId){
        return new ResponseEntity<>(iTagBiz.getOne(creatorId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String,List<Tag>>> getAll(){
        Map<String, List<Tag>> result=new HashMap();
        result.put("tags",iTagBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
