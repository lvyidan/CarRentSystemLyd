package com.jd.framwork.sys.user.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Vector;

/**
 * 数据库连接池
 * 
 * @author zcg
 */

public class DbConnectionPool {

	private String driver; //
	private String url;
	private String username;
	private String password;
	private int poolSize;
	private Vector<Connection> pool;
	private static DbConnectionPool instance;

	/**
	 * 构造方法私有化
	 */
	private DbConnectionPool() {
		init();
	}

	/**
	 * 获取数据库地址池连接（连接池的实例对象）
	 */
	public static DbConnectionPool getinstance() {
		if (null == instance) {
			instance = new DbConnectionPool();
		}
		return instance;
	}

	/**
	 * 初始化方法
	 */
	private void init() {
		pool = new Vector<Connection>();
		readConfig();
		addConnection();
	}

	/**
	 * 向连接池添加链接
	 */
	private void addConnection() {

		try {
			Class.forName(this.driver);
			for (int i = 0; i < poolSize; i++) {
				Connection conn = DriverManager.getConnection(this.url,
						this.username, this.password);
				pool.add(conn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 从连接池取出一个连接
	 */
	public synchronized Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);// 从连接池取出一个连接
			pool.remove(conn);// 将连接池中暂时清除连接
			return conn;
		}
		return null;
	}

	/**
	 * 释放连接
	 */
	public synchronized void release(Connection conn) {
		pool.add(conn);
	}

	/**
	 * 销毁连接
	 */
	public void distory() {
		try {
			for (int i = 0; i < pool.size(); i++) {
				Connection conn = pool.get(i);
				pool.remove(conn);
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取属性文件
	 */
	public void readConfig() {
		try {
			Properties prop = new Properties();
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("pool.properties");
			prop.load(is);

			this.driver = prop.getProperty("driver");
			this.url = prop.getProperty("url");
			this.username = prop.getProperty("username");
			this.password = prop.getProperty("password");
			this.poolSize = Integer.parseInt(prop.getProperty("poolSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
