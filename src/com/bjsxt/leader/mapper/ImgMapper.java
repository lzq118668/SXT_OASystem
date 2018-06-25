package com.bjsxt.leader.mapper;

import com.bjsxt.leader.pojo.Img;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImgMapper {
    @Select("select * from t_img where bid=#{bid}")
    List<Img>  selByBid(@Param("bid") int bid);

}
