package com.bjsxt.base.mapper;

import com.bjsxt.base.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("select * from t_role where rid=#{0}")
    Role selRole(int rid);

}
