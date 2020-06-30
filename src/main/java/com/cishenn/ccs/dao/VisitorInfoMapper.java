package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitorInfoMapper {
    int save(VisitorInfo visitorInfo);

    int update(String ip, VisitorInfo visitorInfo);

    int delete(String ip);

    VisitorInfo getOne(String ip);

    List<VisitorInfo> getAll();
}
