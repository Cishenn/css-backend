package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IWorkOrderReplyBiz;
import com.cishenn.ccs.entity.WorkOrderReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workorderreply")
public class WorkOrderReplyController {
    @Autowired
    IWorkOrderReplyBiz iWorkOrderReplyBiz;

    @PostMapping("/")
    void save(@RequestBody WorkOrderReply workOrderReply){

        iWorkOrderReplyBiz.save(workOrderReply);
    }

    @DeleteMapping("/{workOrderId}")
    void delete(@PathVariable Integer workOrderId){

        iWorkOrderReplyBiz.delete(workOrderId);
    }

    @PutMapping("/{workOrderId}")
    void update(@PathVariable Integer workOrderId,@RequestBody WorkOrderReply workOrderReply){
        iWorkOrderReplyBiz.update(workOrderId,workOrderReply);
    }

    @GetMapping("/{workOrderId}")
    ResponseEntity<WorkOrderReply> getOne(@PathVariable Integer workOrderId){
        return new ResponseEntity<>(iWorkOrderReplyBiz.getOne(workOrderId), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<WorkOrderReply>>> getAll(){
        Map<String, List<WorkOrderReply>> result=new HashMap();
//        put函数中的字符串不知道写法是否正确
        result.put("workorderreply",iWorkOrderReplyBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
