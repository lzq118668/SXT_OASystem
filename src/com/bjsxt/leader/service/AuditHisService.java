package com.bjsxt.leader.service;

import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditHisService {

    /**
     * 查询我的审核历史
     * @param id
     * @return时
     */
    List<Audit> selReimHis(@Param("id") int id);
}
