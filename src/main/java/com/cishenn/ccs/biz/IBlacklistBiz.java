package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Blacklist;

import java.util.List;

public interface IBlacklistBiz {
    public int save(Blacklist blacklist);

    int delete(Integer customerId);

    Blacklist getOne(Integer customerId);

    List<Blacklist> getAll();
}
