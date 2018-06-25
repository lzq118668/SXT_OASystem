package com.bjsxt.employee.service.impl;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.employee.mapper.ApproverMapper;
import com.bjsxt.employee.service.ApproverService;

import java.util.List;

public class ApproverServiceImpl implements ApproverService {
    @Override
    public List<User> selAppr() {
        ApproverMapper mapper = MyBatisUtil.getSession().getMapper(ApproverMapper.class);
        return mapper.selAppr();
    }
}
