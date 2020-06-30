package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.RoleManage;

import java.util.List;

public interface IRoleManageBiz {
    void save(RoleManage roleManage);

    void update(Integer roleId, RoleManage roleManage);

    void delete(Integer roleId);

    RoleManage getOne(Integer roleId);

    List<RoleManage> getAll();
}
