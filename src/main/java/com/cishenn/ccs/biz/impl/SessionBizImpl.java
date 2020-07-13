package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ISessionBiz;
import com.cishenn.ccs.dao.ServicerMapper;
import com.cishenn.ccs.dao.SessionMapper;
import com.cishenn.ccs.entity.Session;
import com.cishenn.ccs.exception.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionBizImpl implements ISessionBiz {
    @Autowired
    SessionMapper sessionMapper;

    @Override
    public List<Session> getSessionList(Integer customerServiceId, Integer type, Integer pageNum) {
        return sessionMapper.getSessionList(customerServiceId,type,pageNum);
    }

    @Override
    public int save(Session cs_session) {
        return sessionMapper.save(cs_session);
    }

    @Override
    public void updateMsgCount(String sessionId, String type) {
        sessionMapper.updateMsgCount(sessionId,type);
    }

    @Override
    public void closeSessionBy(String userName,String type) {
        sessionMapper.closeSessionBy(userName, type);
    }

    @Override
    public void delete(Integer id) {
        int result=sessionMapper.delete(id);
        if(result==0){
            throw new SessionException("Delete Session Entity Error");
        }
    }

    @Override
    public void update(Integer id, Session session) {
        int result=sessionMapper.update(id, session);
        if(result==0){
            throw new SessionException("Update Session Entity Error");
        }
    }

    @Override
    public Session getOne(Integer id) {
        Session result=sessionMapper.getOne(id);
        if(result==null){
            throw new SessionException("Get One Session Entity Error(maybe no such id)");
        }
        return result;
    }

    @Override
    public List<Session> getAll() {
        return sessionMapper.getAll();

    }
}
