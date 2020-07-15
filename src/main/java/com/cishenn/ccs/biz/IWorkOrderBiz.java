package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWorkOrderBiz {
    int save(WorkOrder workOrder);

    int delete(Integer id);

    WorkOrder getOne(Integer id);

    List<WorkOrder> getAll();

    PageInfo<WorkOrder> getWorkOrderList(Integer id, int currentPage, int pageSize);

    PageInfo<WorkOrder> getSelectedWorkOrderList(String state, String priority, String type, String channel, String nickName, String serviceGroup, int currentPage, int pageSize);

    List<ElOption> getStateOptions();

    List<ElOption> getPriorityOptions();

    List<ElOption> getTypeOptions();

    List<ElOption> getChannelOptions();

    List<ElOption> getServicerOptions();

    List<ElOption> getGroupOptions();

    List<ElOption> getPriorityOptions(String state, String nickName);

    List<ElOption> getTypeOptions(String state, String nickName);

    List<ElOption> getChannelOptions(String state, String nickName);

    List<ElOption> getGroupOptions(String state, String nickName);

    PageInfo<WorkOrder> getOrderTotal(String state, String nickName, int currentPage, int pageSize);
}
