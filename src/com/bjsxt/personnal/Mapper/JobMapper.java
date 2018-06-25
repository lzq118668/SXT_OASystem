package com.bjsxt.personnal.Mapper;

import com.bjsxt.personnal.pojo.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface JobMapper {
    /**
     * 查询岗位
     * @return
     */
    @Select("select * from t_job")
    List<Job> selJob();

    /**
     * 修改职位信息
     * @param id  传入部门的id
     * @return
     */
    @Update("update t_job set jname=#{jname},jmark=#{jmark} where id=#{id}")
    int updJob(@Param("id") int id, @Param("jname") String jname, @Param("jmark") String mark);

    /**
     * 删除职位
     * @param id
     * @return
     */
    @Delete("delete from t_job where id=#{id};")
    int deLJob(@Param("id") int id);
    /**
     * 添加职位
     * @param job
     * @return
     */
    @Insert("insert into t_job values(#{id},#{jname},#{jmark})")
    int addJob(Job job);


}
