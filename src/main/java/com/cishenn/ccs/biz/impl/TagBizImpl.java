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
    public void update(Integer id, Tag tag) {
        int result=tagMapper.update(id,tag);
        if(result==0){
            throw new TagException("Update Tag Entity Error");
        }
    }

    @Override
    public void delete(Integer id) {
        int result=tagMapper.delete(id);
        if(result==0){
            throw new TagException("Delete Tag Entity Error");
        }
    }

    @Override
    public Tag getOne(Integer id) {
        Tag result=tagMapper.getOne(id);
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
