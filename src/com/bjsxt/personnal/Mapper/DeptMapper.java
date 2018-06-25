package com.bjsxt.personnal.Mapper;

import com.bjsxt.personnal.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptMapper {
    /**
     * 查询所有的部门
     * @return
     */
    @Select("select * from t_dept")
    List<Dept> selDept();

    /**
     * 修改部门信息
     * @param id  传入部门的id
     * @return
     */
    @Update("update t_dept set dname=#{dname},loc=#{loc} where id=#{id}")
    int updDept(@Param("id") int id,@Param("dname") String dname,@Param("loc") String loc);
}
