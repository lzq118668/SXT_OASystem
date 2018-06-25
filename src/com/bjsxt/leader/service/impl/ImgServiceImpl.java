package com.bjsxt.leader.service.impl;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.leader.mapper.ImgMapper;
import com.bjsxt.leader.pojo.Img;
import com.bjsxt.leader.service.ImgService;

import java.util.List;

public class ImgServiceImpl implements ImgService {
    @Override
    public List<Img> selByBid(int bid) {
        ImgMapper mapper = MyBatisUtil.getSession().getMapper(ImgMapper.class);
        List<Img> imgs = mapper.selByBid(bid);
        return  imgs;
    }
}
