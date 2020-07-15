package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ISystemMessageBiz;
import com.cishenn.ccs.dao.SystemMessageMapper;
import com.cishenn.ccs.entity.SystemMessage;
import com.cishenn.ccs.entity.VisitorInfo;
import com.cishenn.ccs.exception.SystemMessageException;
import com.cishenn.ccs.exception.VisitorInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMessageBizImpl implements ISystemMessageBiz {
    @Autowired
    SystemMessageMapper systemMessageMapper;

    @Override
    public void save(SystemMessage systemMessage) {
        int result=systemMessageMapper.save(systemMessage);
        if(result==0){
            throw new SystemMessageException("Create SystemMessage Entity Error");
        }
    }

    @Override
    public void update(Integer id, SystemMessage systemMessage) {
        int result=systemMessageMapper.update(id,systemMessage);
        if(result==0){
            throw new SystemMessageException("Update SystemMessage Entity Error");
        }
    }

    @Override
    public void delete(Integer id) {
        int result=systemMessageMapper.delete(id);
        if(result==0){
            throw new SystemMessageException("Delete SystemMessage Entity Error");
        }
    }

    @Override
    public SystemMessage getOne(Integer id) {
        SystemMessage result=systemMessageMapper.getOne(id);
        if(result==null){
            throw new SystemMessageException("Get One SystemMessage Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<SystemMessage> getAll() {
        return systemMessageMapper.getAll();
    }
}
