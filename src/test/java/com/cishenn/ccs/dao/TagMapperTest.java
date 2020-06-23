package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagMapperTest {
    @Autowired
    private TagMapper tagMapper;

    @Test
    void save() {
        Tag tag = new Tag();
        tag.setId(2);
        tag.setDesc("hh");
        tag.setName("fuck");
        tag.setCreator_id(1);
        tag.setCreate_time(new Date(11,11,11));
        tag.setType(2);
        int res=tagMapper.save(tag);
        assertEquals(1,res);
    }
}