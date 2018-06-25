package com.bjsxt.personnal.Mapper;

import com.bjsxt.base.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    /**
     * 添加员工
     * @param user
     * @return
     */
    @Insert("INSERT INTO `t_user` VALUES (#{id}, #{jid}, #{did}, #{username},123, #{name}, #{gender}, #{birthday}, #{birthday}, NULL, 1,#{emptype}, #{phone}, #{qq}, #{contacts}, #{idcard}, #{mgr}, #{rid});")
    int addUser(User user);

    /**
     * 添加员工的  上级领导  需要user.name  和user.id
     * @return
     */
    @Select("select * from t_user where emptype=1")
    List<User>  selUser();


/*=======================================*/
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Update("update t_user set username=#{0},did=#{1},jid=#{2},birthday=#{3},hiredate=#{4},phone=#{5},qq=#{6},contacts=#{7} where id=#{8}")
    int updUser(String username, int did, int jid, Date birthday, Date hiredate, String phone, String qq, String contacts, int id);
    /**
     * 查询所有的员工信息
     */
      List<User> selUser(String username,  int  isjob, Date hiredate);

    /**
     *删除用户信息
     */
    @Delete("delete from t_user where id=#{0}")
    int delUser(int id);
}
