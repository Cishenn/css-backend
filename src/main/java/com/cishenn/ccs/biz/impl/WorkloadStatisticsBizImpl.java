package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IWorkloadStatisticsBiz;
import com.cishenn.ccs.dao.WorkloadStatisticsMapper;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkloadStatistics;
import com.cishenn.ccs.exception.AttendanceStatsException;
import com.cishenn.ccs.exception.WorkloadStatisticsException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkloadStatisticsBizImpl implements IWorkloadStatisticsBiz {
    @Autowired
    WorkloadStatisticsMapper workloadStatisticsMapper;

    @Override
    public int save(WorkloadStatistics workloadStatistics) {
        int result=workloadStatisticsMapper.save(workloadStatistics);
        if(result==0){
            throw new WorkloadStatisticsException("Save WorkloadStatistics Entity Error");
        }

        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=workloadStatisticsMapper.delete(id);
        if(result==0){
            throw new WorkloadStatisticsException("delete WorkloadStatistics Entity Error");
        }

        return 0;
    }

    @Override
    public WorkloadStatistics getOne(Integer id) {
        WorkloadStatistics result = workloadStatisticsMapper.getOne(id);
        if(result == null){
            throw new WorkloadStatisticsException("getOne WorkloadStatistics Entity Error");
        }

        return result;
    }

    @Override
    public List<WorkloadStatistics> getAll() {
        return workloadStatisticsMapper.getAll();
    }

    @Override
    public PageInfo<WorkloadStatistics> getWorkloadStatisticsList(Integer id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(workloadStatisticsMapper.getAll());
        return pageInfo;
    }

    @Override
    public PageInfo<WorkloadStatistics> getSelectedWorkloadStatisticsList(String nickName, String serviceGroup, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = null;
        if(nickName.equals("全部客服") && serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workloadStatisticsMapper.getAll());
        }else if(nickName.equals("全部客服") && !serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workloadStatisticsMapper.getByGroup(serviceGroup));
        }else if(!nickName.equals("全部客服") && serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workloadStatisticsMapper.getByServicer(nickName));
        }else if(!nickName.equals("全部客服") && !serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workloadStatisticsMapper.getSelected(nickName,serviceGroup));
        }
        return pageInfo;
    }

    @Override
    public List<ElOption> getServicerOptions() {
        List<String> servicerElement = workloadStatisticsMapper.getServicerOptions();
        List<ElOption> servicerOptions = new ArrayList<>();
        ElOption tempOption = new ElOption();
        tempOption.setValue("全部客服");
        tempOption.setLabel("全部客服");
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
        List<String> groupElement = workloadStatisticsMapper.getGroupOptions();
        List<ElOption> groupOptions = new ArrayList<>();
        ElOption tempOption = new ElOption();
        tempOption.setValue("全部客服组");
        tempOption.setLabel("全部客服组");
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
