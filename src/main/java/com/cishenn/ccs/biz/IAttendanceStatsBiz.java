package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Customer;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAttendanceStatsBiz {
    int save(AttendanceStats attendanceStats);

    int delete(Integer id);

    int update(Integer id, AttendanceStats attendanceStats);

    AttendanceStats getOne(Integer id);

    List<AttendanceStats> getAll();

    PageInfo<AttendanceStats> getAttendanceList(Integer id,int currentPage,int pageSize);
}
