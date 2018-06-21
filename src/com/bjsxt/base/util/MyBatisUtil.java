package com.bjsxt.base.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis工具类
 * 
 * @author leo
 *
 */
public class MyBatisUtil {

	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-cfg.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取SqlSession
	 * 
	 * @return {@ SqlSession}
	 */
	public static SqlSession getSession() {
		if (tl.get() == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}

	/**
	 * 关闭资源
	 */
	public static void close() {
		if (tl.get() != null) {
			tl.get().close();
			tl.remove();
		}
	}
}
