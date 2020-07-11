package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Session;

import java.util.List;

public interface ISessionBiz {
    List<Session> getSessionList(Integer customerServiceId, Integer type, Integer pageNum);

    int save(Session cs_session);

    void updateMsgCount(String sessionId, String type);

    void closeSessionBy(String userName,String type);

    void delete(Integer id);

    void update(Integer id, Session session);

    Session getOne(Integer id);

    List<Session> getAll();
}
