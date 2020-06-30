package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.INoticeBiz;
import com.cishenn.ccs.dao.NoticeMapper;
import com.cishenn.ccs.entity.Notice;
import com.cishenn.ccs.exception.CustomerException;
import com.cishenn.ccs.exception.NoticeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBizImpl implements INoticeBiz {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public int save(Notice notice) {
        int result=noticeMapper.save(notice);
        if(result==0){
            throw new NoticeException("Save Notice Entity Error");
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result=noticeMapper.delete(id);
        if(result==0){
            throw new NoticeException("delete Notice Entity Error");
        }
        return 0;
    }

    @Override
    public int update(Integer id, Notice notice) {
        int result=noticeMapper.update(id, notice);
        if(result==0){
            throw new NoticeException("update Notice Entity Error");
        }
        return 0;
    }

    @Override
    public Notice getOne(Integer id) {
        Notice result=noticeMapper.getOne(id);
        if(result==null){
            throw new NoticeException("getOne Notice Entity Error");
        }
        return result;
    }

    @Override
    public List<Notice> getAll() {
        return noticeMapper.getAll();
    }
}
