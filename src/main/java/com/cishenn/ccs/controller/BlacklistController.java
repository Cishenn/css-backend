package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IBlacklistBiz;
import com.cishenn.ccs.entity.Blacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blacklist")
public class BlacklistController {
    @Autowired
    IBlacklistBiz blacklistBiz;

    /**
     * 对外提供创建客服
     * @param blacklist
     * @return
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public /*@RequestBody*/ String save(Blacklist blacklist){
        // TODO
//        blacklist.save();
        return blacklist.toString();
    }
}
