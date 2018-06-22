package com.bjsxt.employee.service;

import com.bjsxt.employee.pojo.Signin;

import java.util.List;

public interface SigninService {

    /**
    * 根据user的ID查询自己的签到记录。
    *
    *@author leo
    *@param uid
    *@return {@link Signin} List<Signin>
    */
    List<Signin> selSign(int uid);

    /**
    * 用户当日签到时插入当日签到的信息。
    *
    *@author leo
    *@param signin
    *@return int
    */

    int insSign(Signin signin);

    /**
    * 更新签退信息或签退。
    *
    *@author leo
    *@param id 当天签到的签到项ID

    *@return int
    */
    int insSignout(String id);
}
