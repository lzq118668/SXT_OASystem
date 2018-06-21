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
}
