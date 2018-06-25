package com.bjsxt.base.mapper;

import com.bjsxt.base.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {

    User selUser(@Param("auth") String auth,@Param("password") String password);

    @Select("select * from t_user where id=#{0}")
    User selUserById(int id);

    @Update("update t_user set phone=#{1},qq=#{2},contacts=#{3} where id=#{0}")
    int updUser(int id,String phone,String qq,String contacts);

    @Update("update t_user set password = #{1} where id=#{0}")
    int updPwd(int id,String npwd);


}
