package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.ViewStatistics;

import java.util.List;

public interface IViewStatisticsBiz {
    int save(ViewStatistics viewStatistics);

    int delete(Integer id);

    int update(Integer id, ViewStatistics viewStatistics);

    ViewStatistics getOne(Integer id);

    List<ViewStatistics> getAll();
}
