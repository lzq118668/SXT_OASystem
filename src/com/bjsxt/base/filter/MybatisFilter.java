package com.bjsxt.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bjsxt.base.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

@WebFilter("*.action")
public class MybatisFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	* 封装session的获取和关闭，以及事务的提交。
	*
	*@author leo
	 *@param request
	 *@param response
	 *@param chain
	*@return
	*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SessionFilter.doFilter()");
		// 打开Session
		SqlSession session = MyBatisUtil.getSession();
		try {
			// 该干嘛干嘛
			chain.doFilter(request, response);
			// 事务的提交
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 事务回滚
			session.rollback();
		} finally {
			// 关闭session
			MyBatisUtil.close();
		}
	}

	@Override
	public void destroy() {
	}

}
