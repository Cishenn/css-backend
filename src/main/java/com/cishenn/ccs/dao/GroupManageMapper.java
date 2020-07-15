package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.GroupManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupManageMapper {
    int save(GroupManage groupmanage);

    int update(Integer groupId, GroupManage groupmanage);

    int delete(Integer groupId);

    GroupManage getOne(Integer groupId);

    List<GroupManage> getAll();
}
