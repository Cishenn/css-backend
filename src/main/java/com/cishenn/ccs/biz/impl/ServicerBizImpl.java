package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.IServicerBiz;
import com.cishenn.ccs.dao.ServicerMapper;
import com.cishenn.ccs.entity.Servicer;
import com.cishenn.ccs.exception.ServicerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicerBizImpl implements IServicerBiz {
    @Autowired
    ServicerMapper servicerMapper;


    @Override
    public void save(Servicer servicer) {
        int result=servicerMapper.save(servicer);
        if(result==0){
            throw new ServicerException("Create Servicer Entity Error");
        }
    }

    @Override
    public void update(Integer id, Servicer servicer) {
        int result=servicerMapper.update(id,servicer);
        if(result==0){
            throw new ServicerException("Update Servicer Entity Error");
        }
    }

    @Override
    public void delete(Integer id) {
        int result=servicerMapper.delete(id);
        if(result==0){
            throw new ServicerException("Delete Servicer Entity Error");
        }
    }

    @Override
    public Servicer getOne(Integer id) {
        Servicer result=servicerMapper.getOne(id);
        if(result==null){
            throw new ServicerException("Get One Servicer Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<Servicer> getAll() {
        return servicerMapper.getAll();
    }
}
