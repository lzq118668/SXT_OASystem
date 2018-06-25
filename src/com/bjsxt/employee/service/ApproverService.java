package com.bjsxt.employee.service;

import com.bjsxt.base.pojo.User;

import java.util.List;

public interface ApproverService {

    /**
     * 查找审查报销人展示列表。
     *
     *@author leo
     *@param
     *@return {@link User}
     */
    List<User> selAppr();
}
