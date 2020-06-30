package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.CommonWord;
import com.cishenn.ccs.entity.Servicer;

import java.util.List;

public interface ICommonWordBiz {
    void save(CommonWord servicer);

    void delete(Integer id);

    void update(Integer id, Servicer servicer);

    Object getOne(Integer id);

    List<Servicer> getAll();
}
