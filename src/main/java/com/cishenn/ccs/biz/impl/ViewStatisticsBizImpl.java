package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IViewStatisticsBiz;
import com.cishenn.ccs.dao.AttendanceStatsMapper;
import com.cishenn.ccs.dao.ViewStatisticsMapper;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.ViewStatistics;
import com.cishenn.ccs.exception.AttendanceStatsException;
import com.cishenn.ccs.exception.ViewStatisticsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewStatisticsBizImpl implements IViewStatisticsBiz {
    @Autowired
    ViewStatisticsMapper viewStatisticsMapper;


    @Override
    public int save(ViewStatistics viewStatistics) {
        int result=viewStatisticsMapper.save(viewStatistics);
        if(result==0){
            throw new ViewStatisticsException("Save ViewStatistics Entity Error");
        }

        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=viewStatisticsMapper.delete(id);
        if(result==0){
            throw new ViewStatisticsException("delete ViewStatistics Entity Error");
        }

        return 0;
    }

    @Override
    public int update(Integer id, ViewStatistics viewStatistics) {
        int result=viewStatisticsMapper.update(id, viewStatistics);
        if(result==0){
            throw new ViewStatisticsException("update ViewStatistics Entity Error");
        }

        return 0;
    }

    @Override
    public ViewStatistics getOne(Integer id) {
        ViewStatistics result = viewStatisticsMapper.getOne(id);
        if(result == null){
            throw new ViewStatisticsException("getOne ViewStatistics Entity Error");
        }

        return result;
    }

    @Override
    public List<ViewStatistics> getAll() {
        return viewStatisticsMapper.getAll();
    }
}
