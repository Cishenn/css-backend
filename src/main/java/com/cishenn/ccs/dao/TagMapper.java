package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    /**
     * 新建标签
     * @param tag
     * @return
     */
    public int save(Tag tag);

    /**
     * 删除
     */

}
