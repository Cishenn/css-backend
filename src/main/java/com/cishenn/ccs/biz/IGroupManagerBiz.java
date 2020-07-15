package com.cishenn.ccs.biz;
import com.cishenn.ccs.entity.GroupManage;
import java.util.List;

public interface IGroupManagerBiz {

        void save(GroupManage groupmanage);

        void update(Integer groupId, GroupManage groupmanage );

        void delete(Integer groupId);

        GroupManage getOne(Integer groupId);

        List<GroupManage> getAll();
}
