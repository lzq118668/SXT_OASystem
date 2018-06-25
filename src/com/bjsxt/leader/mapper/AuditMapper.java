package com.bjsxt.leader.mapper;

import com.bjsxt.leader.pojo.Audit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditMapper {

    /**
     * 我的审批历史的查询具体的报销项
     * @param id 传入的报销人的id
     * @return
     */
     List<Audit> selAuditMx(@Param("id") int id);


     List<ReimItem>  selReimMx(@Param("id") int id);
    /**
     * 我的待审批的查询具体的报销项
     * @param id 传入的报销人的id
     * @return
     */
    List<ReimItem> selReimMxW(@Param("id") int id);

    /**
     * 查询报销人的具体审核记录
     * @param bid 报销人的id
     * @return
     */
    List<Audit> selHisByBid(@Param("id") int bid);

    /**
     * 审批的方法
     * @param bid 报销单的单号
     * @param sid  审批人的id
     * @return
     */
    int auditAdd(@Param("bid") int bid, @Param("sid") int sid, @Param("mark") String mark, @Param("result") String result);
}
