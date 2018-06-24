package com.bjsxt.base.service;

import com.bjsxt.base.pojo.User;

public interface UserService {
    /**
    * 查找用户的Service接口
    *
    *@author leo
    *@param auth
    *@param password
    *@return {@link User}
    */
    User selUser(String auth,String password);

    /**
    * 修改个人信息。
    *
    *@author leo
    *@param id
    *@param phone
    *@param qq
    *@param contacts
    *@return int
    */
    int insUser(int id,String phone,String qq,String contacts);

    User selUserById(int id);
}
