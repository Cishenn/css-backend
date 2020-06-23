package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    public int save(Tag tag);
}
