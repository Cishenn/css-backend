package com.cishenn.ccs.biz.impl;


import com.cishenn.ccs.biz.IWorkQualityStatisticsBiz;
import com.cishenn.ccs.dao.NoticeMapper;
import com.cishenn.ccs.dao.WorkQualityStatisticsMapper;
import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.entity.WorkQualityStatistics;
import com.cishenn.ccs.exception.NoticeException;
import com.cishenn.ccs.exception.WorkQualityStatisticsException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkQualityStatisticsBizImpl implements IWorkQualityStatisticsBiz {
    @Autowired
    WorkQualityStatisticsMapper workQualityStatisticsMapper;

    @Override
    public int save(WorkQualityStatistics workQualityStatistics) {
        int result=workQualityStatisticsMapper.save(workQualityStatistics);
        if(result==0){
            throw new WorkQualityStatisticsException("Save WorkQualityStatistics Entity Error");
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=workQualityStatisticsMapper.delete(id);
        if(result==0){
            throw new WorkQualityStatisticsException("delete WorkQualityStatistics Entity Error");
        }
        return 0;
    }

    @Override
    public int update(Integer id, WorkQualityStatistics workQualityStatistics) {
        int result=workQualityStatisticsMapper.update(id, workQualityStatistics);
        if(result==0){
            throw new WorkQualityStatisticsException("update WorkQualityStatistics Entity Error");
        }
        return 0;
    }

    @Override
    public WorkQualityStatistics getOne(Integer id) {
        WorkQualityStatistics result=workQualityStatisticsMapper.getOne(id);
        if(result==null){
            throw new WorkQualityStatisticsException("getOne WorkQualityStatistics Entity Error");
        }
        return result;
    }

    @Override
    public List<WorkQualityStatistics> getAll() {
        return workQualityStatisticsMapper.getAll();
    }

    @Override
    public PageInfo<WorkQualityStatistics> getWorkQualityList(Integer id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(workQualityStatisticsMapper.getAll());
        return pageInfo;
    }

    @Override
    public PageInfo<WorkQualityStatistics> getSelectedWorkQualityList(String nickName, String serviceGroup, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = null;
        if(nickName.equals("全部客服") && serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workQualityStatisticsMapper.getAll());
        }else if(nickName.equals("全部客服") && !serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workQualityStatisticsMapper.getByGroup(serviceGroup));
        }else if(!nickName.equals("全部客服") && serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workQualityStatisticsMapper.getByServicer(nickName));
        }else if(!nickName.equals("全部客服") && !serviceGroup.equals("全部客服组")){
            pageInfo = new PageInfo(workQualityStatisticsMapper.getSelected(nickName,serviceGroup));
        }
        return pageInfo;
    }
}
