package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Blacklist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlacklistMapper {
    public int save(Blacklist blacklist);
}
