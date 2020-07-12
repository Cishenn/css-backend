package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.biz.IWorkOrderBiz;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Blacklist;
import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkOrder;
import com.cishenn.ccs.uitls.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/work_order")
@CrossOrigin
public class WorkOrderController {
    @Autowired
    IWorkOrderBiz iWorkOrderBiz;

    @PostMapping("/")
    void save(@RequestBody WorkOrder workOrder) {
        iWorkOrderBiz.save(workOrder);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        iWorkOrderBiz.delete(id);
    }

    @GetMapping("/{id}")
    Result getOne(@PathVariable Integer id) {
        return Result.ok(iWorkOrderBiz.getOne(id));
    }

    @GetMapping("/")
    Result getAll() {
        Map<String, List<WorkOrder>> result = new HashMap<>();
        result.put("WorkOrder", iWorkOrderBiz.getAll());
        return Result.ok(result);
    }

    @GetMapping("/page")
    public PageInfo currentWorkOrder(Integer id,
                                      @RequestParam(required = false,defaultValue ="1")int currentPage,
                                      @RequestParam(required = false,defaultValue ="10")int pageSize){
        PageInfo<WorkOrder> pageInfo = iWorkOrderBiz.getWorkOrderList(id,currentPage,pageSize);
        return pageInfo;
    }

    @GetMapping("/selectPage")
    public PageInfo currentSelectedWorkOrder(String state,
                                             String priority,
                                             String type,
                                             String channel,
                                              String nickName,
                                              String serviceGroup,
                                              @RequestParam(required = false,defaultValue ="1")int currentPage,
                                              @RequestParam(required = false,defaultValue ="10")int pageSize){
        PageInfo<WorkOrder> pageInfo = iWorkOrderBiz.getSelectedWorkOrderList(state,priority,type,channel,nickName,serviceGroup,currentPage,pageSize);
        return pageInfo;
    }

    @GetMapping("/stateOptions")
    Result getStateOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getStateOptions());
        return Result.ok(result);
    }

    @GetMapping("/priorityOptions")
    Result getPriorityOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getPriorityOptions());
        return Result.ok(result);
    }

    @GetMapping("/typeOptions")
    Result getTypeOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getTypeOptions());
        return Result.ok(result);
    }

    @GetMapping("/channelOptions")
    Result getChannelOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getChannelOptions());
        return Result.ok(result);
    }

    @GetMapping("/servicerOptions")
    Result getServicerOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getServicerOptions());
        return Result.ok(result);
    }

    @GetMapping("/groupOptions")
    Result getGroupOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkOrderBiz.getGroupOptions());
        return Result.ok(result);
    }
}
