package com.cishenn.ccs.entity;

import lombok.Data;

@Data
public class CommonWord {
    private String content;
    private String lib;
    private String type;
//    杨老板组这个是主码，感觉有点问题
    private Integer creatorId;
}
