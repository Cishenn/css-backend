package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Notice;

import java.util.List;

public interface INoticeBiz {
    int save(Notice notice);

    int delete(Integer id);

    int update(Integer id, Notice notice);

    Notice getOne(Integer id);

    List<Notice> getAll();
}
