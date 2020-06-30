package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    int save(Tag tag);

    int update(Integer id, Tag tag);

    int delete(Integer id);

    Tag getOne(Integer id);

    List<Tag> getAll();
}
