package com.bjsxt.leader.servlcet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import com.bjsxt.leader.service.AuditHisService;
import com.bjsxt.leader.service.impl.AuditHisServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/auditHis.action")
public class AuditHisServlet extends BaseServlet {
    AuditHisService ahs=new AuditHisServiceImpl();
    public void reimHis(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        int id=user.getId();
        System.out.println(id);
        List<Audit> reimHis = ahs.selReimHis(id);
        System.out.println(reimHis);
        //for循环   查询出来的具体报销明细相加，为报销的总金额
       for (int i = 0; i <reimHis.size() ; i++) {
            double money =0;
            for (int j = 0; j <reimHis.get(i).getReimItems().size() ; j++) {
                money+=reimHis.get(i).getReimItems().get(j).getMoney();
            }
          // System.out.println(money+"money");
            reimHis.get(i).setMoney(money);
           System.out.println(reimHis.get(i).getMoney()+"我的总金额");
        }
        //System.out.println(reimHis);
        req.getSession().setAttribute("reimHis", reimHis);
        resp.getWriter().print("helloword");
        resp.sendRedirect(req.getContextPath()+"leader/myAudit.jsp");

    }

}
