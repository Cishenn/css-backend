package com.cishenn.ccs.controller;
import com.cishenn.ccs.biz.ITagBiz;
import com.cishenn.ccs.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    ITagBiz iTagBiz;
    //花括号中的id需要修改
    @PostMapping("/")
    void save(@RequestBody Tag tag){
        iTagBiz.save(tag);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iTagBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id,@RequestBody Tag tag){
        iTagBiz.update(id, tag);
    }

    @GetMapping("/{id}")
    ResponseEntity<Tag> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(iTagBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String,List<Tag>>> getAll(){
        Map<String, List<Tag>> result=new HashMap();
        result.put("tags",iTagBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
