package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.ViewStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViewStatisticsMapper {
    int save(ViewStatistics viewStatistics);

    int delete(Integer id);

    int update(Integer id, ViewStatistics viewStatistics);

    ViewStatistics getOne(Integer id);

    List<ViewStatistics> getAll();
}
