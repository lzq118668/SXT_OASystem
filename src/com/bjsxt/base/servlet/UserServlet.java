package com.bjsxt.base.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.service.UserService;
import com.bjsxt.base.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/login.action")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = userService.selUser(username, password);
        req.getSession().setAttribute("user", user);
        //check(req,resp);
        if(user != null){
            user.setPassword(null);
            req.getSession().setAttribute("user", user);
            // 页面跳转
            resp.sendRedirect(req.getContextPath() + "/main.jsp");
        }else{
            req.getSession().setAttribute("msg", "用户名或密码错误, 请重新登录!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }

    public void check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String piccode = (String) req.getSession().getAttribute("piccode");
        String checkcode = req.getParameter("checkcode");
        resp.setContentType("text/html;charset=utf-8");
        if (checkcode.equalsIgnoreCase(piccode)) {
            resp.getWriter().print("ture");
        } else {
            resp.getWriter().print("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            index = r.nextInt(len);
            sb.append(ch[index]);
        }
        //把验证码字符串放入Session
        req.getSession().setAttribute("piccode", sb.toString());

        super.doGet(req, resp);
    }
}
