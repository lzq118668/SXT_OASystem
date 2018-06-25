package com.bjsxt.leader.servlcet;


import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.leader.pojo.Audit;
import com.bjsxt.leader.pojo.Reimburse;
import com.bjsxt.leader.service.ReimburseService;
import com.bjsxt.leader.service.impl.ReimburseServiceImpl;
@WebServlet("/reim.actoin")
public class ReimburseServlet  extends BaseServlet{
   /**
    * 查询待审核的报销
    * @param req
    */
	 ReimburseService rs=new ReimburseServiceImpl();
	 /**
	 * test==========================
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void reim(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//int id =Integer.parseInt(req.getParameter("id"));
		User user = (User) req.getSession().getAttribute("user");
		int id=user.getId();
		System.out.println(id);
		List<Audit> reim = rs.selReim1(id);
		for (int i = 0; i <reim.size() ; i++) {
			double money =0;
			for (int j = 0; j <reim.get(i).getReimItems().size() ; j++) {
				money+=reim.get(i).getReimItems().get(j).getMoney();
			}
			reim.get(i).setMoney(money);
		}
		System.out.println(reim);
		req.getSession().setAttribute("reim", reim);
		resp.getWriter().print("helloword");
		resp.sendRedirect(req.getContextPath()+"leader/toAudit.jsp");
	}




}
