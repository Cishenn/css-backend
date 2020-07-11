package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.dao.AttendanceStatsMapper;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Customer;
import com.cishenn.ccs.exception.AttendanceStatsException;
import com.cishenn.ccs.exception.CustomerException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceStasBizImpl implements IAttendanceStatsBiz {
    @Autowired
    AttendanceStatsMapper attendanceStatsMapper;


    @Override
    public int save(AttendanceStats attendanceStats) {
        int result=attendanceStatsMapper.save(attendanceStats);
        if(result==0){
            throw new AttendanceStatsException("Save AttendanceStats Entity Error");
        }

        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=attendanceStatsMapper.delete(id);
        if(result==0){
            throw new AttendanceStatsException("delete AttendanceStats Entity Error");
        }

        return 0;
    }

    @Override
    public int update(Integer id, AttendanceStats attendanceStats) {
        int result=attendanceStatsMapper.update(id, attendanceStats);
        if(result==0){
            throw new AttendanceStatsException("update AttendanceStats Entity Error");
        }

        return 0;
    }

    @Override
    public AttendanceStats getOne(Integer id) {
        AttendanceStats result = attendanceStatsMapper.getOne(id);
        if(result == null){
            throw new AttendanceStatsException("getOne AttendanceStats Entity Error");
        }

        return result;
    }

    @Override
    public List<AttendanceStats> getAll() {
        return attendanceStatsMapper.getAll();
    }

    @Override
    public PageInfo<AttendanceStats> getAttendanceList(Integer id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(attendanceStatsMapper.getAll());
        return pageInfo;
    }
}
