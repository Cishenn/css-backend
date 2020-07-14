package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IWorkOrderBiz;
import com.cishenn.ccs.dao.AttendanceStatsMapper;
import com.cishenn.ccs.dao.WorkOrderMapper;
import com.cishenn.ccs.entity.AttendanceStats;
import com.cishenn.ccs.entity.ElOption;
import com.cishenn.ccs.entity.WorkOrder;
import com.cishenn.ccs.exception.AttendanceStatsException;
import com.cishenn.ccs.exception.WorkOrderException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkOrderBizImpl implements IWorkOrderBiz {
    @Autowired
    WorkOrderMapper workOrderMapper;


    @Override
    public int save(WorkOrder workOrder) {
        int result=workOrderMapper.save(workOrder);
        if(result==0){
            throw new WorkOrderException("Save WorkOrder Entity Error");
        }

        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=workOrderMapper.delete(id);
        if(result==0){
            throw new WorkOrderException("delete WorkOrder Entity Error");
        }

        return 0;

    }

    @Override
    public WorkOrder getOne(Integer id) {
        WorkOrder result = workOrderMapper.getOne(id);
        if(result == null){
            throw new WorkOrderException("getOne WorkOrder Entity Error");
        }

        return result;
    }

    @Override
    public List<WorkOrder> getAll() {
        return workOrderMapper.getAll();
    }

    @Override
    public PageInfo<WorkOrder> getWorkOrderList(Integer id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(workOrderMapper.getAll());
        return pageInfo;
    }

    @Override
    public PageInfo<WorkOrder> getSelectedWorkOrderList(String state, String priority, String type, String channel, String nickName, String serviceGroup, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = null;
        pageInfo = new PageInfo(workOrderMapper.getSelected(state,priority,type,channel,nickName,serviceGroup));
        return pageInfo;
    }

    @Override
    public List<ElOption> getStateOptions() {
        List<String> stateElement = workOrderMapper.getStateOptions();
        List<ElOption> stateOptions = new ArrayList<>();
        for(int i=0;i<stateElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(stateElement.get(i));
            temp.setLabel(stateElement.get(i));
            stateOptions.add(temp);
        }
        return stateOptions;
    }

    @Override
    public List<ElOption> getPriorityOptions() {
        List<String> priorityElement = workOrderMapper.getPriorityOptions();
        List<ElOption> priorityOptions = new ArrayList<>();
        for(int i=0;i<priorityElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(priorityElement.get(i));
            temp.setLabel(priorityElement.get(i));
            priorityOptions.add(temp);
        }
        return priorityOptions;
    }

    @Override
    public List<ElOption> getTypeOptions() {
        List<String> typeElement = workOrderMapper.getTypeOptions();
        List<ElOption> typeOptions = new ArrayList<>();
        for(int i=0;i<typeElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(typeElement.get(i));
            temp.setLabel(typeElement.get(i));
            typeOptions.add(temp);
        }
        return typeOptions;
    }

    @Override
    public List<ElOption> getChannelOptions() {
        List<String> channelElement = workOrderMapper.getChannelOptions();
        List<ElOption> channelOptions = new ArrayList<>();
        for(int i=0;i<channelElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(channelElement.get(i));
            temp.setLabel(channelElement.get(i));
            channelOptions.add(temp);
        }
        return channelOptions;
    }

    @Override
    public List<ElOption> getServicerOptions() {
        List<String> servicerElement = workOrderMapper.getServicerOptions();
        List<ElOption> servicerOptions = new ArrayList<>();
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
        List<String> groupElement = workOrderMapper.getGroupOptions();
        List<ElOption> groupOptions = new ArrayList<>();
        for(int i=0;i<groupElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(groupElement.get(i));
            temp.setLabel(groupElement.get(i));
            groupOptions.add(temp);
        }
        return groupOptions;
    }

    @Override
    public List<ElOption> getPriorityOptions(String state, String nickName) {
        List<String> priorityElement = workOrderMapper.getPriorityOptionsWith(state,nickName);
        List<ElOption> priorityOptions = new ArrayList<>();
        for(int i=0;i<priorityElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(priorityElement.get(i));
            temp.setLabel(priorityElement.get(i));
            priorityOptions.add(temp);
        }
        return priorityOptions;
    }

    @Override
    public List<ElOption> getTypeOptions(String state, String nickName) {
        List<String> typeElement = workOrderMapper.getTypeOptionsWith(state,nickName);
        List<ElOption> typeOptions = new ArrayList<>();
        for(int i=0;i<typeElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(typeElement.get(i));
            temp.setLabel(typeElement.get(i));
            typeOptions.add(temp);
        }
        return typeOptions;
    }

    @Override
    public List<ElOption> getChannelOptions(String state, String nickName) {
        List<String> channelElement = workOrderMapper.getChannelOptionsWith(state,nickName);
        List<ElOption> channelOptions = new ArrayList<>();
        for(int i=0;i<channelElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(channelElement.get(i));
            temp.setLabel(channelElement.get(i));
            channelOptions.add(temp);
        }
        return channelOptions;
    }

    @Override
    public List<ElOption> getGroupOptions(String state, String nickName) {
        List<String> groupElement = workOrderMapper.getGroupOptionsWith(state,nickName);
        List<ElOption> groupOptions = new ArrayList<>();
        for(int i=0;i<groupElement.size();i++){
            ElOption temp = new ElOption();
            temp.setValue(groupElement.get(i));
            temp.setLabel(groupElement.get(i));
            groupOptions.add(temp);
        }
        return groupOptions;
    }

    @Override
    public PageInfo<WorkOrder> getOrderTotal(String state, String nickName, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo pageInfo = null;
        pageInfo = new PageInfo(workOrderMapper.getOrderTotal(state,nickName));
        return pageInfo;
    }
}
