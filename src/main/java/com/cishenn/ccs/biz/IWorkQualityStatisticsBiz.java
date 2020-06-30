package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.entity.WorkQualityStatistics;

import java.util.List;

public interface IWorkQualityStatisticsBiz {
    int save(WorkQualityStatistics workQualityStatistics);

    int delete(Integer id);

    int update(Integer id, WorkQualityStatistics workQualityStatistics);

    WorkQualityStatistics getOne(Integer id);

    List<WorkQualityStatistics> getAll();
}
