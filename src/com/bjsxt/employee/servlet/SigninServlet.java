package com.bjsxt.employee.servlet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.employee.pojo.Signin;
import com.bjsxt.employee.service.SigninService;
import com.bjsxt.employee.service.impl.SigninServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign.action")
public class SigninServlet extends BaseServlet {

    private SigninService signinService= new SigninServiceImpl();

    public void signin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = req.getParameter("id");
        Signin signin = new Signin();
        signin.setUid(Integer.parseInt(uid));
        int i = signinService.insSign(signin);
        if (i>0){
            req.setAttribute("msg","添加成功");
        }else{
            req.setAttribute("msg","添加失败");
        }

    }
    public void signout(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        


        	}
    public void selSign(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    	}
}
