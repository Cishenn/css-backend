package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.biz.IViewStatisticsBiz;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.ViewStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/view_statistics")
public class ViewStatisticsController {
    @Autowired
    IViewStatisticsBiz iViewStatisticsBiz;

    @PostMapping("/")
    void save(@RequestBody ViewStatistics viewStatistics) {
        iViewStatisticsBiz.save(viewStatistics);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        iViewStatisticsBiz.delete(id);
    }

    @GetMapping("/{id}")
    ResponseEntity getOne(@PathVariable Integer id) {
        return new ResponseEntity(iViewStatisticsBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<ViewStatistics>>> getAll() {
        Map<String, List<ViewStatistics>> result = new HashMap<>();
        result.put("ViewStatistics", iViewStatisticsBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
