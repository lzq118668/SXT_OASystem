package com.bjsxt.personnal.service;

import com.bjsxt.base.pojo.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    /**
     * 添加员工
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 查询员工
     * @return
     */
    List<User> selUser();
    /*==================================*/
    /**
     * 修改用户信息
     */
    int updUser(String username, int did, int jid, Date birthday, Date hiredate, String phone, String qq, String contacts, int id);
    /**
     * 查询所有的员工信息
     */
    List<User>selUser(String username,  String isjob, Date hiredate);


    /**
     * 删除用户信息
     */
    int delUser(int id);
}
