package com.onuo.common.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 封装了Mybatis核心类,SqlSession的打开与关闭
 * SqlSessionFactoryBuilder:用于构造SqlSessonFactory
 * SqlSessionFactory :重量级的对象,用于生产SqlSession
 * SqlSession:封装了 PreparedStatement,用于执行sql + 一级缓存
 */
public class MybatisUtil {
	private static SqlSessionFactory sessionFactory = null;
	private static SqlSession session = null;
	
	static{//类加载的时候执行,只执行一次
		InputStream is =null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	/**
	 * 获得SqlSession对象
	 * @return
	 */
	public static SqlSession getSession(){
		session = sessionFactory.openSession();//创建一个新的SqlSession对象
		return session;
	}
	 
	/**
	 * 关闭SqlSession
	 */
	public static void closeSession(){
		if(session !=null)
			session.close();
	}

}
