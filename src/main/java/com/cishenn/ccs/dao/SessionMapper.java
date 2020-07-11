package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {

    List<Session> getSessionList(Integer customerServiceId, Integer type, Integer pageNum);

    int save(Session cs_session);

    void updateMsgCount(String sessionId, String type);

    void closeSessionBy(String userName, String type);

    int delete(Integer id);

    int update(Integer id, Session session);

    Session getOne(Integer id);

    List<Session> getAll();
}
