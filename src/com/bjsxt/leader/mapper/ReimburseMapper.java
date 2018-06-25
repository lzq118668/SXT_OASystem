package com.bjsxt.leader.mapper;

import java.util.List;

import com.bjsxt.leader.pojo.Audit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.leader.pojo.Reimburse;

public interface ReimburseMapper {
	/**
	 * 查询当前用户的待审批的报销
	 * @param id 当前用户的id 代表审批人的id
	 * @return
	 */
    List<Reimburse>  selReim(@Param("id") int id);

    List<Audit> selReim1(@Param("id") int id);

   /**
    * 查询待审核报销单的
    * @param bid   selRemin()方法查询出来的bid传入
    * @return  string  姓名
    */
   /* @Select("select u.`name` from t_user u LEFT JOIN t_reimburse r on r.bid=u.id where r.bid=#{0}")
    List<String >   selByBid(int bid);*/
}
