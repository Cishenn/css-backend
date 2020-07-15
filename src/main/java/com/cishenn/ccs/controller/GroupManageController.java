package com.cishenn.ccs.controller;
import com.cishenn.ccs.biz.IGroupManagerBiz;
import com.cishenn.ccs.entity.GroupManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groupManage")
public class GroupManageController {
    @Autowired
    IGroupManagerBiz iGroupManagerBiz;

    @PostMapping("/")
    void save(@RequestBody GroupManage groupManage){
        iGroupManagerBiz.save(groupManage);
    }

    @DeleteMapping("/{groupId}")
    void delete(@PathVariable Integer groupId){
        iGroupManagerBiz.delete(groupId);
    }

    @PutMapping("/{groupId}")
    void update(@PathVariable Integer groupId,@RequestBody GroupManage groupManage){
        iGroupManagerBiz.update(groupId, groupManage);
    }

    @GetMapping("/{groupId}")
    ResponseEntity<GroupManage> getOne(@PathVariable Integer groupId){
        return new ResponseEntity<>(iGroupManagerBiz.getOne(groupId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String,List<GroupManage>>> getAll(){
        Map<String, List<GroupManage>> result=new HashMap();
        result.put("tag",iGroupManagerBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
