package com.bjsxt.leader.service.impl;

import com.bjsxt.base.filter.MybatisFilter;
import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.leader.mapper.AuditHisMapper;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import com.bjsxt.leader.service.AuditHisService;

import java.util.List;

public class AuditHisServiceImpl  implements AuditHisService {
    @Override
    public List<Audit> selReimHis(int id) {
        AuditHisMapper mapper= MyBatisUtil.getSession().getMapper(AuditHisMapper.class);
        List<Audit> list= mapper.selReimHis(id);
        return list;
    }
}
