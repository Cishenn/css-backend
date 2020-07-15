package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkloadStatistics;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWorkloadStatisticsBiz {
    int save(WorkloadStatistics workloadStatistics);

    int delete(Integer id);

    WorkloadStatistics getOne(Integer id);

    List<WorkloadStatistics> getAll();

    PageInfo<WorkloadStatistics> getWorkloadStatisticsList(Integer id, int currentPage, int pageSize);

    PageInfo<WorkloadStatistics> getSelectedWorkloadStatisticsList(String nickName, String serviceGroup, int currentPage, int pageSize);

    List<ElOption> getServicerOptions();

    List<ElOption> getGroupOptions();
}
