package com.bjsxt.leader.service.impl;

import java.util.List;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.leader.mapper.ReimItem;
import com.bjsxt.leader.mapper.ReimburseMapper;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import com.bjsxt.leader.service.ReimburseService;

public class ReimburseServiceImpl implements ReimburseService{

	@Override
	public List<Reimburse> selReim(int id) {
		ReimburseMapper mapper = MyBatisUtil.getSession().getMapper(ReimburseMapper.class);
		List<Reimburse> list = mapper.selReim(id);

		return list;
	}

    @Override
    public List<Audit> selReim1(int id) {
        ReimburseMapper mapper = MyBatisUtil.getSession().getMapper(ReimburseMapper.class);
        List<Audit> list = mapper.selReim1(id);
        return list;
    }


	 /*public List<Reimburse> selReimHis(int id){
         ReimburseMapper Mapper = MyBatisUtil.getSession().getMapper(ReimburseMapper.class);
         List<Reimburse> list = Mapper.selReim(id);

         return list;

     }*/
	/*@Override
	public List<String > selByBid(int bid) {
		ReimburseMapper Mapper = MyBatisUtil.getSession().getMapper(ReimburseMapper.class);
		List<String> list = Mapper.selByBid(bid);
		return list;
	}*/

}
