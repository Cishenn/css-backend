package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Blacklist;
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
@RequestMapping("/attendance_stats")
@CrossOrigin
public class AttendanceStatsController {
    @Autowired
    IAttendanceStatsBiz iAttendanceStatsBiz;

    @PostMapping("/")
    void save(@RequestBody AttendanceStats attendanceStats) {
        iAttendanceStatsBiz.save(attendanceStats);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        iAttendanceStatsBiz.delete(id);
    }

    @GetMapping("/{id}")
    Result getOne(@PathVariable Integer id) {
        return Result.ok(iAttendanceStatsBiz.getOne(id));
    }

    @GetMapping("/")
    Result getAll() {
        Map<String, List<AttendanceStats>> result = new HashMap<>();
        result.put("AttendanceStats", iAttendanceStatsBiz.getAll());
        return Result.ok(result);
    }

    @GetMapping("/page")
    public PageInfo currentAttendance(Integer id,
                                      @RequestParam(required = false,defaultValue ="1")int currentPage,
                                      @RequestParam(required = false,defaultValue ="10")int pageSize){
        PageInfo<AttendanceStats> pageInfo = iAttendanceStatsBiz.getAttendanceList(id,currentPage,pageSize);
        return pageInfo;
    }
}
