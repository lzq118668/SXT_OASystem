package com.bjsxt.personnal.service;

import com.bjsxt.personnal.pojo.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface JobService {
    /**
     * 查询岗位
     * @return
     */
    List<Job> selJob();

    /**
     * 修改职位信息
     * @param id  传入部门的id
     * @return
     */
    int updJob( int id,  String jname,  String jmark);

    /**
     * 删除职位
     * @param id
     * @return
     */

    int deLJob( int id);
    /**
     * 添加职位
     * @param job
     * @return
     */
    int addJob(Job job);
}
