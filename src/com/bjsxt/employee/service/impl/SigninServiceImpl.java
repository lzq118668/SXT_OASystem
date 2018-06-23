package com.bjsxt.employee.service.impl;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.employee.mapper.SigninMapper;
import com.bjsxt.employee.pojo.Signin;
import com.bjsxt.employee.service.SigninService;

import java.sql.Date;
import java.util.List;

public class SigninServiceImpl implements SigninService {


    @Override
    public List<Signin> selSign(int uid) {
        SigninMapper mapper = MyBatisUtil.getSession().getMapper(SigninMapper.class);
        return mapper.selSign(uid);
    }

    @Override
    public int insSign(Signin signin) {
        SigninMapper mapper = MyBatisUtil.getSession().getMapper(SigninMapper.class);
        return mapper.insSign(signin);
    }

    @Override
    public int insSignout(String id) {
        SigninMapper mapper = MyBatisUtil.getSession().getMapper(SigninMapper.class);
        int tmid = Integer.parseInt(id);
        return mapper.insSignout(tmid);
    }

    @Override
    public Signin selToday(Date date) {
        SigninMapper mapper = MyBatisUtil.getSession().getMapper(SigninMapper.class);
        return mapper.selToday(date);
    }
}
