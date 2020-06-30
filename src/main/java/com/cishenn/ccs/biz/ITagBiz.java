package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Tag;

import java.util.List;

public interface ITagBiz {
    void save(Tag tag);

    void update(Integer creatorId, Tag tag);

    void delete(Integer creatorId);

    Tag getOne(Integer creatorId);

    List<Tag> getAll();
}
