package com.bjsxt.personnal.service;

import com.bjsxt.personnal.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门
     * @return
     */
    List<Dept>  selDept();

    /**
     * 修改部门
     * @param id
     * @param dname
     * @param loc
     * @return
     */
    int updDept(int id,  String dname, String loc);
}
