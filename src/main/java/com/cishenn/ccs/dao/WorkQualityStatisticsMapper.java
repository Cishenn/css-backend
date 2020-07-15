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

    List getByGroup(String serviceGroup);

    List getByServicer(String nickName);

    List getSelected(String nickName, String serviceGroup);

    List<String> getServicerOptions();

    List<String> getGroupOptions();
}
