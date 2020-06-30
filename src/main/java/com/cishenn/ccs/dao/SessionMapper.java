package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {
    int save(Session session);

    int delete(Integer id);

    int update(Integer id, Session session);

    Session getOne(Integer id);

    List<Session> getAll();
}
