package com.bjsxt.personnal.service.impl;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.personnal.Mapper.UserMapper;
import com.bjsxt.personnal.service.UserService;

import java.util.Date;
import java.util.List;


public class UserServiceImpl  implements UserService {
    /**
     * 添加员工
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        return mapper.addUser(user);
    }

    /**
     * 查询员工
     * @return
     */
    @Override
    public List<User> selUser() {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        return mapper.selUser();
    }
   /*=============================================================*/
    /**
     * 修改用户信息
     * @param
     * @return
     */
    @Override
    public int updUser(String username, int did, int jid, Date birthday, Date hiredate, String phone, String qq, String contacts, int id) {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        return mapper.updUser( username, did,jid, birthday, hiredate, phone, qq, contacts, id);
    }
    @Override
    public List<User> selUser(String username, String isjob, Date hiredate) {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        //Integer sdid = did == null ? null : Integer.parseInt(did);
        Integer isjob1 = isjob == null ? null : Integer.parseInt(isjob);
        return mapper.selUser(username, isjob1, hiredate);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public int delUser(int id) {
        UserMapper mapper = MyBatisUtil.getSession().getMapper(UserMapper.class);
        return mapper.delUser(id);
    }
}
