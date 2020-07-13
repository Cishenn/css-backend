package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Customer;
import com.cishenn.ccs.entity.ElOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceStatsMapper {
    int save(AttendanceStats attendanceStats);

    int delete(Integer id);

    int update(Integer id, AttendanceStats attendanceStats);

    AttendanceStats getOne(Integer id);

    List<AttendanceStats> getAll();

    List getSelected(String nickName,String serviceGroup);

    List getByGroup(String serviceGroup);

    List getByServicer(String nickName);

    List getServicerOptions();

    List getGroupOptions();
}
