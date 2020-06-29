package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Servicer;

import java.util.List;

public interface ServicerMapper {
    int save(Servicer servicer);

    int update(Integer id, Servicer servicer);

    int delete(Integer id);

    Servicer getOne(Integer id);

    List<Servicer> getAll();
}
