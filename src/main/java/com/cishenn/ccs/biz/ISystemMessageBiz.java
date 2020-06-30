package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.SystemMessage;

import java.util.List;

public interface ISystemMessageBiz {
    void save(SystemMessage systemMessage);

    void update(Integer id, SystemMessage systemMessage);

    void delete(Integer id);

    SystemMessage getOne(Integer id);

    List<SystemMessage> getAll();
}
