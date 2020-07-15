package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.WorkOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkOrderMapper {
    int save(WorkOrder workOrder);

    int delete(Integer id);

    WorkOrder getOne(Integer id);

    List<WorkOrder> getAll();

    List getSelected(String state, String priority, String type, String channel, String nickName, String serviceGroup);

    List<String> getStateOptions();

    List<String> getPriorityOptions();

    List<String> getTypeOptions();

    List<String> getChannelOptions();

    List<String> getServicerOptions();

    List<String> getGroupOptions();

    List<String> getPriorityOptionsWith(String state, String nickName);

    List<String> getTypeOptionsWith(String state, String nickName);

    List<String> getChannelOptionsWith(String state, String nickName);

    List<String> getGroupOptionsWith(String state, String nickName);

    List getOrderTotal(String state, String nickName);
}
