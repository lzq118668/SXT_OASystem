package com.bjsxt.employee.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.employee.service.ApproverService;
import com.bjsxt.employee.service.impl.ApproverServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/approver.action")
public class ApproverServlet extends BaseServlet {

    private ApproverService approverService =new ApproverServiceImpl();

    public void selApprover(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<User> users = approverService.selAppr();
        req.getSession().setAttribute("users",users);

        resp.sendRedirect(req.getContextPath()+"/Empoyee/expenseAdd.jsp");
    }
}
