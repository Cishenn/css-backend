package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Customer;
import com.cishenn.ccs.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int save(Notice notice);

    int delete(Integer id);

    int update(Integer id, Notice notice);

    Notice getOne(Integer id);

    List<Notice> getAll();
}
