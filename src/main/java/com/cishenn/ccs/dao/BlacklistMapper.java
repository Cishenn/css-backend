package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Blacklist;
import com.cishenn.ccs.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //这是一个mapper接口，需要为其创建实现类，并创建对象
public interface BlacklistMapper {
    public int save(Blacklist blacklist);

    int delete(Integer customerId);

    Blacklist getOne(Integer customerId);

    List<Blacklist> getAll();
}
