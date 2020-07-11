package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.INoticeBiz;
import com.cishenn.ccs.biz.IWorkQualityStatisticsBiz;
import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.entity.WorkQualityStatistics;
import com.cishenn.ccs.uitls.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workQualityStatistics")
@CrossOrigin
public class WorkQualityStatisticsController {
    @Autowired
    IWorkQualityStatisticsBiz iWorkQualityStatisticsBiz;

    @PostMapping("/")
    void save(@RequestBody WorkQualityStatistics workQualityStatistics){
        iWorkQualityStatisticsBiz.save(workQualityStatistics);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iWorkQualityStatisticsBiz.delete(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable Integer id, @RequestBody WorkQualityStatistics workQualityStatistics){
        iWorkQualityStatisticsBiz.update(id, workQualityStatistics);
    }

    @GetMapping("/{id}")
    Result getOne(@PathVariable Integer id){
        return Result.ok(iWorkQualityStatisticsBiz.getOne(id));
    }

    @GetMapping("/")
    Result getAll(){
        Map<String, List<WorkQualityStatistics>> result=new HashMap<>();
        result.put("WorkQualityStatistics", iWorkQualityStatisticsBiz.getAll());
        return Result.ok(result);
    }
}
