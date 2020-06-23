package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Blacklist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlacklistMapperTest {
    @Autowired
    private BlacklistMapper blacklistMapper;

    @Test
    void save() {
        Blacklist blacklist = new Blacklist();
        blacklist.setId(5);
        blacklist.setReason("Mocking others");
        blacklist.setCid(1);
        blacklist.setSid(1);
        blacklist.setTime(new Date(2020, 5, 17));
        blacklist.setCreate_time(new Date(2020, 5, 17));
        int res = blacklistMapper.save(blacklist);
        assertEquals(1,res);
    }
}