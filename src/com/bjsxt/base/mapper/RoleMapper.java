package com.bjsxt.base.mapper;

import com.bjsxt.base.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("select * from t_role where id=#{0}")
    Role selRole(int rid);

}
