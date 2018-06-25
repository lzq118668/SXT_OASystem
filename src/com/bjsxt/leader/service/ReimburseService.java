package com.bjsxt.leader.service;

import java.util.List;

import com.bjsxt.leader.pojo.Audit;
import org.apache.ibatis.annotations.Param;

import com.bjsxt.leader.pojo.Reimburse;

public interface ReimburseService {
	/**
	 * 查询当前用户的待审批的报销
	 * @param id 当前用户的id 代表审批人的id
	 * @return
	 */
    List<Reimburse>  selReim(int id);

	/**
	 *
	 *
	 * @param id
	 * @return
	 */
	List<Audit>  selReim1(int id);
    // List<Reimburse> selReimHis(int id);
   /**
    * 查询待审核报销单的
    * @param bid   selRemin()方法查询出来的bid传入
    * @return  string  姓名
    */
  // List<String >  selByBid(int bid);
}
