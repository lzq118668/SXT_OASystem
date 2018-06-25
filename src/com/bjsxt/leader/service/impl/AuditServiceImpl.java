package com.bjsxt.leader.service.impl;

import com.bjsxt.base.util.MyBatisUtil;
import com.bjsxt.leader.mapper.AuditMapper;
import com.bjsxt.leader.mapper.ReimItem;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.service.AuditService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class AuditServiceImpl implements AuditService {
    @Override
    public List<ReimItem> selReimMx(int id) {
         AuditMapper mapper=MyBatisUtil.getSession().getMapper(AuditMapper.class);
        List<ReimItem> list  = mapper.selReimMx(id);
        return list ;
    }
    @Override
    public List<Audit> selAuditMx(int id) {
        AuditMapper mapper=MyBatisUtil.getSession().getMapper(AuditMapper.class);
        List<Audit> list  = mapper.selAuditMx(id);
        return list ;
    }
    /**
     * 我的待审批的查询具体的报销项
     * @param id 传入的报销人的id
     * @return
     */
    public  List<ReimItem> selReimMxW( int id){
        AuditMapper mapper=MyBatisUtil.getSession().getMapper(AuditMapper.class);
        List<ReimItem> list = mapper.selReimMxW(id);
        return  list;
    }
      /* * 查询报销人的具体审核记录
     * @param bid 报销人的id
     * @return
             */
      public  List<Audit> selHisByBid(int bid){
          AuditMapper mapper=MyBatisUtil.getSession().getMapper(AuditMapper.class);
          List<Audit> audits = mapper.selHisByBid(bid);
          return  audits;

      }

    public  int auditAdd( int bid,int sid, String mark,String result) {
        AuditMapper mapper = MyBatisUtil.getSession().getMapper(AuditMapper.class);
        int i = mapper.auditAdd(bid, sid, mark, result);
        return i;
    }
}
