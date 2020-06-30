package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IRoleManageBiz;
import com.cishenn.ccs.entity.RoleManage;
import com.cishenn.ccs.entity.VisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rolemanage")
public class RoleManageController {
    @Autowired
    IRoleManageBiz iRoleManageBiz;

    @PostMapping("/")
    void save(@RequestBody RoleManage roleManage){
        iRoleManageBiz.save(roleManage);
    }

    @DeleteMapping("/{roleId}")
    void delete(@PathVariable Integer roleId){
        iRoleManageBiz.delete(roleId);
    }

    @PutMapping("/{roleId}")
    void update(@PathVariable Integer roleId,@RequestBody RoleManage roleManage){
        iRoleManageBiz.update(roleId,roleManage);
    }

    @GetMapping("/{roleId}")
    ResponseEntity<RoleManage> getOne(@PathVariable Integer roleId){
        return new ResponseEntity<>(iRoleManageBiz.getOne(roleId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<RoleManage>>> getAll(){
        Map<String, List<RoleManage>> result=new HashMap();
        //put函数中的字符串不确定是否是这样写的
        result.put("rolemanage",iRoleManageBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
