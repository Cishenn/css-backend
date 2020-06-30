package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.entity.WorkQualityStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkQualityStatisticsMapper {
    int save(WorkQualityStatistics workQualityStatistics);

    int delete(Integer id);

    int update(Integer id, WorkQualityStatistics workQualityStatistics);

    WorkQualityStatistics getOne(Integer id);

    List<WorkQualityStatistics> getAll();
}
