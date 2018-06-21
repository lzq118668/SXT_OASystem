package com.bjsxt.base.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 获取Class对象
		Class<? extends BaseServlet> cls = this.getClass();
		// 接收操作类型
		String op = req.getParameter("op");
		System.out.println(op + "====================================");
		try {
			// 通过反射获取方法
			Method method = cls.getMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			// 调用方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
