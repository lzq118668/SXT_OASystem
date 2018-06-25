package com.bjsxt.personnal.service.impl;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.personnal.Mapper.DeptMapper;
import com.bjsxt.personnal.pojo.Dept;
import com.bjsxt.personnal.service.DeptService;

import java.util.List;

public class DeptServiceImpl  implements DeptService {
    /**
     * 查询所有的部门
     * @return
     */
    @Override
    public List<Dept> selDept() {
        DeptMapper mapper = MyBatisUtil.getSession().getMapper(DeptMapper.class);
        List<Dept> depts = mapper.selDept();
        return depts;
    }
    public int updDept(int id,String dname,String loc) {
        DeptMapper mapper = MyBatisUtil.getSession().getMapper(DeptMapper.class);
       int i = mapper.updDept(id,dname,loc);
        return i;
    }

}
