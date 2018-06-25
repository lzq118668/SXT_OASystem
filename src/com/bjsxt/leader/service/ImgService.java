package com.bjsxt.leader.service;

import com.bjsxt.leader.pojo.Img;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImgService {

    List<Img> selByBid( int bid);
}
