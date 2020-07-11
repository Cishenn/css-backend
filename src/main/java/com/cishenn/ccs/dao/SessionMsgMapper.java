package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.SessionMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMsgMapper {
    @Insert("insert into session_msg(msg_sender_Id,msg_receiver_id,content,session_id,create_time) values(#{msgSenderId},#{msgReceiverId},#{content},#{session.id},#{createTime})")
    void insert(SessionMsg sessionMsg);
}
