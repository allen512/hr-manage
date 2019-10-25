package com.example.spring.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SysMsg {
    private Long id;
    private Long mid;
    private Integer type;
    private Long hrid;
    private Integer state;
    private MsgContent msgContent;

}
