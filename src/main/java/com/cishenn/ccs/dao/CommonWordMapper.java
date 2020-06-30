package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.CommonWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonWordMapper {
    int save(CommonWord commonWord);

    int update(Integer creatorId, CommonWord commonWord);

    int delete(Integer creatorId);

    CommonWord getOne(Integer creatorId);

    List<CommonWord> getAll();

}
