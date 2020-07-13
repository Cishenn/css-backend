package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.SessionMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface SessionMsgMapper {
    @Insert("INSERT INTO session_message (fromVisitor, content, sessionId) " +
            "VALUES (#{fromVisitor}, #{content}, #{sessionId})")
    @Options(useGeneratedKeys = true, keyColumn = "sessionMsgId", keyProperty = "sessionMsgId")
    void insert(SessionMsg sessionMsg);
}
