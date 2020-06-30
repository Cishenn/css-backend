package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.GroupManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupManageMapper {
    int save(GroupManage groupmanage);

    int update(String name, GroupManage groupmanage);

    int delete(String name);

    GroupManage getOne(String name);

    List<GroupManage> getAll();
}
