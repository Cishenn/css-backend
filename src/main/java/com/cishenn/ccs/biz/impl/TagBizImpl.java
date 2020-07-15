package com.cishenn.ccs.biz.impl;


import com.cishenn.ccs.biz.ITagBiz;
import com.cishenn.ccs.dao.TagMapper;
import com.cishenn.ccs.entity.Tag;
import com.cishenn.ccs.exception.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagBizImpl implements ITagBiz {
    @Autowired
    TagMapper tagMapper;


    @Override
    public void save(Tag tag) {
        int result=tagMapper.save(tag);
        if(result==0){
            throw new TagException("Create Tag Entity Error");
        }
    }

    @Override
    public void update(Integer creatorId, Tag tag) {
        int result=tagMapper.update(creatorId,tag);
        if(result==0){
            throw new TagException("Update Tag Entity Error");
        }
    }

    @Override
    public void delete(Integer creatorId) {
        int result=tagMapper.delete(creatorId);
        if(result==0){
            throw new TagException("Delete Tag Entity Error");
        }
    }

    @Override
    public Tag getOne(Integer creatorId) {
        Tag result=tagMapper.getOne(creatorId);
        if(result==null){
            throw new TagException("Get One tag Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<Tag> getAll() {
        return tagMapper.getAll();
    }
}
