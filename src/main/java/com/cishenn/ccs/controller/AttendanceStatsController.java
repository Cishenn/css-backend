package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Blacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendance_stats")
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
    ResponseEntity getOne(@PathVariable Integer id) {
        return new ResponseEntity(iAttendanceStatsBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String, List<AttendanceStats>>> getAll() {
        Map<String, List<AttendanceStats>> result = new HashMap<>();
        result.put("AttendanceStats", iAttendanceStatsBiz.getAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
