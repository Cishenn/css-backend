package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IWorkOrderReplyBiz;
import com.cishenn.ccs.dao.WorkOrderReplyMapper;
import com.cishenn.ccs.entity.SystemMessage;
import com.cishenn.ccs.entity.WorkOrderReply;
import com.cishenn.ccs.exception.SystemMessageException;
import com.cishenn.ccs.exception.WorkOrderReplyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderReplyBizImpl implements IWorkOrderReplyBiz {
    @Autowired
    WorkOrderReplyMapper workOrderReplyMapper;

    @Override
    public void save(WorkOrderReply workOrderReply) {
        int result=workOrderReplyMapper.save(workOrderReply);
        if(result==0){
            throw new WorkOrderReplyException("Create WorkOrderReply Entity Error");
        }
    }

    @Override
    public void update(Integer workOrderId, WorkOrderReply workOrderReply) {
        int result=workOrderReplyMapper.update(workOrderId,workOrderReply);
        if(result==0){
            throw new WorkOrderReplyException("Update WorkOrderReply Entity Error");
        }
    }

    @Override
    public void delete(Integer workOrderId) {
        int result=workOrderReplyMapper.delete(workOrderId);
        if(result==0){
            throw new WorkOrderReplyException("Delete WorkOrderReply Entity Error");
        }
    }

    @Override
    public WorkOrderReply getOne(Integer workOrderId) {
        WorkOrderReply result=workOrderReplyMapper.getOne(workOrderId);
        if(result==null){
            throw new WorkOrderReplyException("Get One WorkOrderReply Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<WorkOrderReply> getAll() {
        return workOrderReplyMapper.getAll();
    }
}
