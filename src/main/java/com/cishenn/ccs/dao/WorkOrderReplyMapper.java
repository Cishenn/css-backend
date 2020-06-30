package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.WorkOrderReply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkOrderReplyMapper {
    int save(WorkOrderReply workOrderReply);

    int update(Integer workOrderId, WorkOrderReply workOrderReply);

    int delete(Integer workOrderId);

    WorkOrderReply getOne(Integer workOrderId);

    List<WorkOrderReply> getAll();
}
