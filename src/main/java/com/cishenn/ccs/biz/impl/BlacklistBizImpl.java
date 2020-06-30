package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.dao.BlacklistMapper;
import com.cishenn.ccs.entity.Blacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service   //告诉springboot这是一个业务对象
public class BlacklistBizImpl implements IBlacklistBiz {
    //依赖的持久化对象
    @Autowired
    BlacklistMapper blacklistMapper;

    @Override
    public int save(Blacklist blacklist) {
        return 0;
    }

    @Override
    public int delete(Integer customerId) {
        return 0;
    }

    @Override
    public Blacklist getOne(Integer customerId) {
        return null;
    }

    @Override
    public List<Blacklist> getAll() {
        return null;
    }
}
