package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Servicer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServicerMapper {
    int save(Servicer servicer);

    int update(Integer id, Servicer servicer);

    int delete(Integer id);

    Servicer getOne(Integer id);

    List<Servicer> getAll();
}
