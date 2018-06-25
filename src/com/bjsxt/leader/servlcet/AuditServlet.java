package com.bjsxt.leader.servlcet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.leader.mapper.ReimItem;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import com.bjsxt.leader.service.AuditHisService;
import com.bjsxt.leader.service.AuditService;
import com.bjsxt.leader.service.impl.AuditHisServiceImpl;
import com.bjsxt.leader.service.impl.AuditServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/audit.action")
public class AuditServlet extends BaseServlet{

        /**
         *我的审核历史 查询具体的报销项
         * @param req
         * @param resp
         * @throws IOException
         */
        public void selReimMx(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            AuditService as=new AuditServiceImpl();
            int id =Integer.parseInt(req.getParameter("id"));
            System.out.println(id);
            List<Audit> reimHis = as.selAuditMx(id);

            req.getSession().setAttribute("reimItems",reimHis);
            resp.sendRedirect(req.getContextPath()+"leader/expenseDetailW.jsp");
        }
    /**
     * 我的待审批的查询具体的报销项
     * @param
     * @return
     */
    public void selReimMxW(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int  id = Integer.parseInt(req.getParameter("id"));
        AuditService as=new AuditServiceImpl();
        List<ReimItem> reimItems = as.selReimMxW(id);
        System.out.println(id);
        System.out.println(reimItems);
        req.getSession().setAttribute("reimItems",reimItems);
        resp.sendRedirect(req.getContextPath()+"leader/expenseDetail.jsp");
    }
    /* * 查询报销人的具体审核记录
     * @param bid 报销人的id
     * @return
     */
    public void selHisByBid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int  bid = Integer.parseInt(req.getParameter("bid"));
        AuditService as=new AuditServiceImpl();
        List<Audit> list = as.selHisByBid(bid);
        System.out.println(bid);
        System.out.println(list);
        req.getSession().setAttribute("list",list);
        resp.sendRedirect(req.getContextPath()+"leader/auditHistory.jsp");
    }

}
