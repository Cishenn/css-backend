package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.WorkloadStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkloadStatisticsMapper {
    int save(WorkloadStatistics workloadStatistics);

    int delete(Integer id);

    WorkloadStatistics getOne(Integer id);

    List<WorkloadStatistics> getAll();

    List getByGroup(String serviceGroup);

    List getByServicer(String nickName);

    List getSelected(String nickName, String serviceGroup);

    List<String> getServicerOptions();

    List<String> getGroupOptions();
}
