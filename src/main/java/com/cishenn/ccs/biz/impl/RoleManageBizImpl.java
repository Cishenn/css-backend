package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IRoleManageBiz;
import com.cishenn.ccs.dao.RoleManageMapper;
import com.cishenn.ccs.entity.RoleManage;
import com.cishenn.ccs.entity.VisitorInfo;
import com.cishenn.ccs.exception.VisitorInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManageBizImpl implements IRoleManageBiz {
    @Autowired
    RoleManageMapper roleManageMapper;

    @Override
    public void save(RoleManage roleManage) {
        int result=roleManageMapper.save(roleManage);
        if(result==0){
            throw new VisitorInfoException("Create RoleManage Entity Error");
        }
    }

    @Override
    public void update(Integer roleId, RoleManage roleManage) {
        int result=roleManageMapper.update(roleId,roleManage);
        if(result==0){
            throw new VisitorInfoException("Update RoleManage Entity Error");
        }
    }

    @Override
    public void delete(Integer roleId) {
        int result=roleManageMapper.delete(roleId);
        if(result==0){
            throw new VisitorInfoException("Delete RoleManage Entity Error");
        }
    }

    @Override
    public RoleManage getOne(Integer roleId) {
        RoleManage result=roleManageMapper.getOne(roleId);
        if(result==null){
            throw new VisitorInfoException("Get One RoleManage Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<RoleManage> getAll() {
        return roleManageMapper.getAll();
    }
}
