package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Servicer;

import java.util.List;

public interface IServicerBiz {
    void save(Servicer servicer);

    void update(Integer id, Servicer servicer);

    void delete(Integer id);

    Servicer getOne(Integer id);

    List<Servicer> getAll();

    Servicer login(Servicer servicer);
}
