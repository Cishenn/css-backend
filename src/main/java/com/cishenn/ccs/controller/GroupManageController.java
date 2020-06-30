package com.cishenn.ccs.controller;
import com.cishenn.ccs.biz.IGroupManagerBiz;
import com.cishenn.ccs.entity.GroupManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class GroupManageController {
    @Autowired
    IGroupManagerBiz iGroupManagerBiz;

    @PostMapping("/")
    void save(@RequestBody GroupManage groupManage){
        iGroupManagerBiz.save(groupManage);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String name){
        iGroupManagerBiz.delete(name);
    }

    @PutMapping("/{id}")
    void update(@PathVariable String name,@RequestBody GroupManage groupManage){
        iGroupManagerBiz.update(name,groupManage);
    }

    @GetMapping("/{id}")
    ResponseEntity<GroupManage> getOne(@PathVariable String name){
        return new ResponseEntity<>(iGroupManagerBiz.getOne(name), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String,List<GroupManage>>> getAll(){
        Map<String, List<GroupManage>> result=new HashMap();
        result.put("tag",iGroupManagerBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
