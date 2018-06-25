package com.bjsxt.leader.servlcet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.service.AuditService;
import com.bjsxt.leader.service.impl.AuditServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/auditAdd.action")
public class AduitAddServlet extends BaseServlet {
    //审核功能
    public void auditAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       // System.out.println(req.getParameter("id"));
       int id=Integer.parseInt(req.getParameter("id"));//审核单的编号
        int sid=Integer.parseInt(req.getParameter("sid"));
        String result = req.getParameter("result");//审核结果
        String mark = req.getParameter("mark");//审核意见
        AuditService  as=new AuditServiceImpl();
        int i = as.auditAdd(id, sid, mark, result);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
         if(i>0){
             resp.getWriter().print("<script language=\"javascript\">alert('审批成功')</script>");
         }else {
             resp.getWriter().print("<script language=\"javascript\">alert('审批提交失败')</script>");
         }
        resp.getWriter().print("<script language=\"javascript\">window.opener=null;window.close();</script>");
        System.out.println(id);
        System.out.println(sid);
        System.out.println(result);
        System.out.println(mark);
        System.out.println(i);



    }

}
