package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAttendanceStatsBiz {
    int save(AttendanceStats attendanceStats);

    int delete(Integer id);

    int update(Integer id, AttendanceStats attendanceStats);

    AttendanceStats getOne(Integer id);

    List<AttendanceStats> getAll();
}
