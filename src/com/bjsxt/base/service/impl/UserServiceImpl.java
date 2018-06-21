package com.bjsxt.base.service.impl;

import com.bjsxt.base.mapper.UserMapper;
import com.bjsxt.base.pojo.User;
import com.bjsxt.base.service.UserService;
import com.bjsxt.base.util.MyBatisUtil;

public class UserServiceImpl implements UserService {
    /**
    * 调用mapper方法查找User封装成方法返回使用。
    *
    *@author leo
    *@param auth
    *@param password
    *@return {@link User}
    */
    @Override
    public User selUser(String auth, String password) {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        User user = mapper.selUser(auth, password);
        return user;
    }
}
