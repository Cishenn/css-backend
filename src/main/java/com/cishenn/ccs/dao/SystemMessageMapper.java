package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.SystemMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemMessageMapper {
    int save(SystemMessage systemMessage);

    int update(Integer id, SystemMessage systemMessage);

    int delete(Integer id);

    SystemMessage getOne(Integer id);

    List<SystemMessage> getAll();
}
