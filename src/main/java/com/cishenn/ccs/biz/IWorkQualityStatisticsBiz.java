package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.entity.WorkQualityStatistics;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWorkQualityStatisticsBiz {
    int save(WorkQualityStatistics workQualityStatistics);

    int delete(Integer id);

    int update(Integer id, WorkQualityStatistics workQualityStatistics);

    WorkQualityStatistics getOne(Integer id);

    List<WorkQualityStatistics> getAll();


    PageInfo<WorkQualityStatistics> getWorkQualityList(Integer id, int currentPage, int pageSize);

    PageInfo<WorkQualityStatistics> getSelectedWorkQualityList(String nickName, String serviceGroup, int currentPage, int pageSize);
}
