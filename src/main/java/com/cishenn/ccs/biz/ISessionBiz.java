package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Session;

import java.util.List;

public interface ISessionBiz {
    void save(Session session);

    void delete(Integer id);

    void update(Integer id, Session session);

    Session getOne(Integer id);

    List<Session> getAll();
}
