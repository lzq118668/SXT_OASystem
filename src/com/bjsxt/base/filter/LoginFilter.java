package com.bjsxt.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.base.pojo.User;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取访问路径
		String uri = req.getRequestURI();
		if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".gif")
				|| uri.endsWith(".jpg") || uri.equals(req.getContextPath() + "/")
				|| uri.endsWith(".htc")
				|| uri.equals(req.getContextPath() + "/login.jsp")
				|| uri.equals(req.getContextPath() + "/login.action")) {
			chain.doFilter(req, resp);
		} else {
			User user = (User) req.getSession().getAttribute("user");
			if (user != null) {
				chain.doFilter(req, resp);
			} else {
				req.getSession().setAttribute("msg", "请先登录再访问!");
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
