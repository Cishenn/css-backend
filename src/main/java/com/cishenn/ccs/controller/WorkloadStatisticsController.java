package com.cishenn.ccs.controller;


import com.cishenn.ccs.biz.IWorkloadStatisticsBiz;
import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkloadStatistics;
import com.cishenn.ccs.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workloadStatistics")
@CrossOrigin
public class WorkloadStatisticsController {
    @Autowired
    IWorkloadStatisticsBiz iWorkloadStatisticsBiz;

    @PostMapping("/")
    void save(@RequestBody WorkloadStatistics workloadStatistics) {
        iWorkloadStatisticsBiz.save(workloadStatistics);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        iWorkloadStatisticsBiz.delete(id);
    }

    @GetMapping("/{id}")
    Result getOne(@PathVariable Integer id) {
        return Result.ok(iWorkloadStatisticsBiz.getOne(id));
    }

    @GetMapping("/")
    Result getAll() {
        Map<String, List<WorkloadStatistics>> result = new HashMap<>();
        result.put("WorkloadStatistics", iWorkloadStatisticsBiz.getAll());
        return Result.ok(result);
    }

    @GetMapping("/page")
    public PageInfo currentWorkloadStatistics(Integer id,
                                      @RequestParam(required = false,defaultValue ="1")int currentPage,
                                      @RequestParam(required = false,defaultValue ="10")int pageSize){
        PageInfo<WorkloadStatistics> pageInfo = iWorkloadStatisticsBiz.getWorkloadStatisticsList(id,currentPage,pageSize);
        return pageInfo;
    }

    @GetMapping("/selectPage")
    public PageInfo currentSelectedWorkloadStatistics(String nickName,
                                              String serviceGroup,
                                              @RequestParam(required = false,defaultValue ="1")int currentPage,
                                              @RequestParam(required = false,defaultValue ="10")int pageSize){
        PageInfo<WorkloadStatistics> pageInfo = iWorkloadStatisticsBiz.getSelectedWorkloadStatisticsList(nickName,serviceGroup,currentPage,pageSize);
        return pageInfo;
    }

    @GetMapping("/servicerOptions")
    Result getServicerOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkloadStatisticsBiz.getServicerOptions());
        return Result.ok(result);
    }

    @GetMapping("/groupOptions")
    Result getGroupOptions() {
        Map<String, List<ElOption>> result = new HashMap<>();
        result.put("ElOption", iWorkloadStatisticsBiz.getGroupOptions());
        return Result.ok(result);
    }

}
