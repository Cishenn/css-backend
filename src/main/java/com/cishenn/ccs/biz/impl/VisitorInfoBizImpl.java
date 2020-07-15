package com.cishenn.ccs.biz.impl;


import com.cishenn.ccs.biz.IVisitorInfoBiz;
import com.cishenn.ccs.dao.VisitorInfoMapper;
import com.cishenn.ccs.entity.VisitorInfo;
import com.cishenn.ccs.exception.VisitorInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorInfoBizImpl implements IVisitorInfoBiz {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Override
    public void save(VisitorInfo visitorInfo) {
        int result=visitorInfoMapper.save(visitorInfo);
        if(result==0){
            throw new VisitorInfoException("Create VisitorInfo Entity Error");
        }
    }

    @Override
    public void update(String ip, VisitorInfo visitorInfo) {
        int result=visitorInfoMapper.update(ip,visitorInfo);
        if(result==0){
            throw new VisitorInfoException("Update VisitorInfo Entity Error");
        }
    }

    @Override
    public void delete(String ip) {
        int result=visitorInfoMapper.delete(ip);
        if(result==0){
            throw new VisitorInfoException("Delete VisitorInfo Entity Error");
        }
    }

    @Override
    public VisitorInfo getOne(String ip) {
        VisitorInfo result=visitorInfoMapper.getOne(ip);
        if(result==null){
            throw new VisitorInfoException("Get One VisitorInfo Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<VisitorInfo> getAll() {
        return visitorInfoMapper.getAll();
    }





}
