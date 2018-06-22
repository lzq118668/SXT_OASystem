package com.bjsxt.base.mapper;

import com.bjsxt.base.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User selUser(@Param("auth") String auth,@Param("password") String password);

}
