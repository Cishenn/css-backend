package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IGroupManagerBiz;

import com.cishenn.ccs.dao.GroupManageMapper;
import com.cishenn.ccs.dao.TagMapper;
import com.cishenn.ccs.entity.GroupManage;
import com.cishenn.ccs.entity.Tag;
import com.cishenn.ccs.exception.GroupManageException;
import com.cishenn.ccs.exception.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupManageBizImpl implements IGroupManagerBiz {

    @Autowired
    GroupManageMapper groupmanagemapper;


    @Override
    public void save(GroupManage manage) {
        int result=groupmanagemapper.save(manage);
        if(result==0){
            throw new GroupManageException("Create GroupManage Entity Error");
        }
    }

    @Override
    public void update(String name, GroupManage groupmanage) {
        int result=groupmanagemapper.update(name,groupmanage);
        if(result==0){
            throw new  GroupManageException("Update GroupManage Entity Error");
        }
    }

    @Override
    public void delete(String name) {
        int result=groupmanagemapper.delete(name);
        if(result==0){
            throw new TagException("Delete  GroupManage Entity Error");
        }
    }

    @Override
    public GroupManage getOne(String name) {
        GroupManage result = groupmanagemapper.getOne(name);
        if(result==null){
            throw new TagException("Get One GroupManage Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<GroupManage> getAll() {
        return groupmanagemapper.getAll();
    }
}