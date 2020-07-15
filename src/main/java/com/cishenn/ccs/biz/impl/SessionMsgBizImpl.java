package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ISessionMsgBiz;
import com.cishenn.ccs.dao.SessionMsgMapper;
import com.cishenn.ccs.entity.SessionMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionMsgBizImpl implements ISessionMsgBiz {
    @Autowired
    private SessionMsgMapper sessionMsgMapper;

    @Override
    public void save(SessionMsg sessionMsg) {
        sessionMsgMapper.insert(sessionMsg);
    }
}
