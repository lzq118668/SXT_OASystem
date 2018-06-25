package com.bjsxt.personnal.service.impl;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.personnal.Mapper.JobMapper;
import com.bjsxt.personnal.pojo.Job;
import com.bjsxt.personnal.service.JobService;

import java.util.List;

public class JobServiceImpl  implements JobService {


    @Override
    public List<Job> selJob() {
        JobMapper mapper = MyBatisUtil.getSession().getMapper(JobMapper.class);
        return mapper.selJob();
    }

    @Override
    public int updJob(int id, String jname, String jmark) {
        JobMapper mapper = MyBatisUtil.getSession().getMapper(JobMapper.class);
        return mapper.updJob(id,jname,jmark);
    }

    @Override
    public int deLJob(int id) {
        JobMapper mapper = MyBatisUtil.getSession().getMapper(JobMapper.class);
        return mapper.deLJob(id);
    }

    @Override
    public int addJob(Job job) {
        JobMapper mapper = MyBatisUtil.getSession().getMapper(JobMapper.class);

        return mapper.addJob(job);
    }
}
