package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.RoleManage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RoleManageMapper {
    int save(RoleManage roleManage);

    int update(Integer roleId, RoleManage roleManage);

    int delete(Integer roleId);

    RoleManage getOne(Integer roleId);

    List<RoleManage> getAll();
}
