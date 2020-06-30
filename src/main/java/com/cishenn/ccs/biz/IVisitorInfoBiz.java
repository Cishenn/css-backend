package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.VisitorInfo;
import java.util.List;

public interface IVisitorInfoBiz {

    void save(VisitorInfo visitorInfo);

    void update(String ip, VisitorInfo visitorInfo);

    void delete(String ip);

    VisitorInfo getOne(String ip);

    List<VisitorInfo> getAll();
}
