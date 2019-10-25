package com.example.spring.mapper;

import com.example.spring.model.Hr;
import com.example.spring.model.MsgContent;
import com.example.spring.model.SysMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMsgMapper {

    int sendMsg(MsgContent msg);

    int addMsg2AllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);

    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("hrid") Long hrid);

    int markRead(@Param("flag") Long flag, @Param("hrid") Long hrid);
}
