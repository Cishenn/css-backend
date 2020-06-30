package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ICommonWordBiz;
import com.cishenn.ccs.dao.CommonWordMapper;
import com.cishenn.ccs.entity.CommonWord;
import com.cishenn.ccs.exception.CommonWordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonWordBizImpl implements ICommonWordBiz {
    @Autowired
    CommonWordMapper commonWordMapper;

    @Override
    public void save(CommonWord commonWord) {
        int result=commonWordMapper.save(commonWord);
        if(result==0){
            throw new CommonWordException("Create CommonWord Entity Error");
        }
    }

    @Override
    public void delete(Integer creatorId) {
        int result=commonWordMapper.delete(creatorId);
        if(result==0){
            throw new CommonWordException("Delete CommonWord Entity Error");
        }
    }

    @Override
    public void update(Integer creatorId, CommonWord commonWord) {
        int result=commonWordMapper.update(creatorId,commonWord);
        if(result==0){
            throw new CommonWordException("Update CommonWord Entity Error");
        }
    }

    @Override
    public CommonWord getOne(Integer creatorId) {
        CommonWord result=commonWordMapper.getOne(creatorId);
        if(result==null){
            throw new CommonWordException("Get One CommonWord Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<CommonWord> getAll() {

        return commonWordMapper.getAll();
    }





}