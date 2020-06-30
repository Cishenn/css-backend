package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Tag;

import java.util.List;

public interface ITagBiz {
    void save(Tag tag);

    void update(Integer id, Tag tag);

    void delete(Integer id);

    Tag getOne(Integer id);

    List<Tag> getAll();
}
