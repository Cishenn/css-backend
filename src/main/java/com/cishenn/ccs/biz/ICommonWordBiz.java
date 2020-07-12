package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.CommonWord;
import java.util.List;

public interface ICommonWordBiz {
    void save(CommonWord commonWord);

    void delete(Integer creatorId);

    void update(Integer creatorId, CommonWord commonWord);

    CommonWord getOne(Integer creatorId);

    List<CommonWord> getOneLib(String lib);

    List<CommonWord> getAll();
}
