package com.bjsxt.personnal.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.base.util.DateUtil;
import com.bjsxt.personnal.service.UserService;
import com.bjsxt.personnal.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/emp.action")
public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();

    /**
     * 查询所有的用户
     * @param req
     * @param resp
     * @throws IOException
     */
    public void selUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        String username=req.getParameter("username");
     //   String did=req.getParameter("did");
        String isjob=req.getParameter("isjob");

        Date hiredate=DateUtil.StrToDate(req.getParameter("hiredate"));
        List<User> list = userService.selUser(username,isjob,hiredate);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        resp.getWriter().print(gson.toJson(list));
    }

    /**
     * 删除用户信息
     */
    public void delUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        resp.getWriter().print(userService.delUser(id));
    }

    /**
     *
     */
    public void updUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            User user=new User();
            int id=Integer.parseInt(req.getParameter("id"));
            String username=req.getParameter("username");
            int did = Integer.parseInt(req.getParameter("did1"));
            int jid = Integer.parseInt(req.getParameter("jid1"));
           Date birthday= DateUtil.StrToDate(req.getParameter("birthday"));
          Date hiredate=DateUtil.StrToDate(req.getParameter("hiredate"));
           String phone= req.getParameter("phone");
         String qq= req.getParameter("qq");
           String contacts= req.getParameter("contacts");
            System.out.print(userService.updUser(username, did,jid, birthday, hiredate, phone, qq, contacts, id));
            resp.getWriter().print(userService.updUser(username, did,jid, birthday, hiredate, phone, qq, contacts, id));
    }
}