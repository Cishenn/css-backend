package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.WorkOrderReply;

import java.util.List;

public interface IWorkOrderReplyBiz {
    void save(WorkOrderReply workOrderReply);

    void update(Integer workOrderId, WorkOrderReply workOrderReply);

    void delete(Integer workOrderId);

    WorkOrderReply getOne(Integer workOrderId);

    List<WorkOrderReply> getAll();
}
