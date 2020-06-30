package com.cishenn.ccs.biz;
import com.cishenn.ccs.entity.GroupManage;
import java.util.List;

public interface IGroupManagerBiz {

        void save(GroupManage groupmanage);

        void update(String name, GroupManage groupmanage );

        void delete(String name);

        GroupManage getOne(String name);

        List<GroupManage> getAll();
}
