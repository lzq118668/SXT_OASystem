package com.bjsxt.employee.mapper;

import com.bjsxt.base.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApproverMapper {

    /**
    * 查找审查报销人展示列表。
    *
    *@author leo
    *@param
    *@return {@link User}
    */
    @Select("select * from t_user where rid=1 or rid=4")
    List<User> selAppr();
}
