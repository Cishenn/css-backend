package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IAttendanceStatsBiz;
import com.cishenn.ccs.dao.AttendanceStatsMapper;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Customer;
import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.exception.AttendanceStatsException;
import com.cishenn.ccs.exception.CustomerException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public PageInfo<AttendanceStats> getSelectedAttendanceList(String nickName, String serviceGroup, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = null;
        if(nickName.equals("????????????") && serviceGroup.equals("???????????????")){
            pageInfo = new PageInfo(attendanceStatsMapper.getAll());
        }else if(nickName.equals("????????????") && !serviceGroup.equals("???????????????")){
            pageInfo = new PageInfo(attendanceStatsMapper.getByGroup(serviceGroup));
        }else if(!nickName.equals("????????????") && serviceGroup.equals("???????????????")){
            pageInfo = new PageInfo(attendanceStatsMapper.getByServicer(nickName));
        }else if(!nickName.equals("????????????") && !serviceGroup.equals("???????????????")){
            pageInfo = new PageInfo(attendanceStatsMapper.getSelected(nickName,serviceGroup));
        }
        return pageInfo;
    }

    @Override
    public List<ElOption> getServicerOptions() {
        List<String> servicerElement = attendanceStatsMapper.getServicerOptions();
        List<ElOption> servicerOptions = new ArrayList<>();
        ElOption tempOption = new ElOption();
        tempOption.setValue("????????????");
        tempOption.setLabel("????????????");
        servicerOptions.add(tempOption);
        for(int i=0;i<servicerElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(servicerElement.get(i));
            temp.setLabel(servicerElement.get(i));
            servicerOptions.add(temp);
        }
        return servicerOptions;
    }

    @Override
    public List<ElOption> getGroupOptions() {
        List<String> groupElement = attendanceStatsMapper.getGroupOptions();
        List<ElOption> groupOptions = new ArrayList<>();
        ElOption tempOption = new ElOption();
        tempOption.setValue("???????????????");
        tempOption.setLabel("???????????????");
        groupOptions.add(tempOption);
        for(int i=0;i<groupElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(groupElement.get(i));
            temp.setLabel(groupElement.get(i));
            groupOptions.add(temp);
        }
        return groupOptions;
    }

}
