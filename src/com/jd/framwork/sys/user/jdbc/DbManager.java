package com.jd.framwork.sys.user.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 封装数据库操作类
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("unused")
public class DbManager {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pastmt;
	private ResultSet rs;
	private static DbManager instance;

	/**
	 * 构造方法私有化
	 */
	private DbManager() {

	}

	/**
	 * 返回数据库操作类的实例化对象
	 */
	public static DbManager getInstance() {
		if (null == instance) {
			instance = new DbManager();
		}
		return instance;
	}

	/**
	 * 获取数据库的链接
	 */
	public Connection getConnection() {
		return DbConnectionPool.getinstance().getConnection();
	}

	/**
	 * 保存数据 sql 所执行的数据库语言 Int 影响的行数
	 * 
	 * @author zcg
	 */
	public int save(String sql) {
		int result = 0;
		try {
			conn = this.getConnection();
			stat = conn.createStatement();
			result = stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	/**
	 * 修改数据 sql执行的数据库语言 int sql语句影响的行数
	 * 
	 * @author zcg
	 */
	public int modify(String sql) {
		int result = 0;
		try {
			conn = this.getConnection();
			stat = conn.createStatement();
			result = stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	/**
	 * 删除数据 sql要执行的语句 int 执行语句影响的行数
	 * 
	 * @author zcg
	 */
	public int delete(String sql) {
		int result = 0;
		try {
			conn = this.getConnection();
			stat = conn.createStatement();
			result = stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	/**
	 * 查询数据库 sql要执行的语句 returnset 返回的结果集
	 * 
	 * @author zcg
	 */
	public ResultSet query(String sql) {
		rs = null;
		try {
			conn = this.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnectionPool.getinstance().release(conn);
			conn = null;
		}
		return rs;
	}

	/**
	 * 分页查询
	 */
	public ResultSet queryByPage(int page, int pageSize, String sql) {
		rs = null;
		try {
			int begin = (page - 1) * pageSize;
			sql += " limit " + begin + "," + pageSize;
			rs = query(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 查询总记录数
	 * 
	 * @param sql
	 * @return int
	 * @author zcg
	 */
	public int getRecordCount(String sql) {
		int count = 0;
		try {
			sql = "select count(*) " + sql.substring(sql.indexOf("from"));
			rs = query(sql);
			rs.next();
			count = rs.getInt(1);
			rs.close();
			rs = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count <= 0)
			count = 0;
		return count;
	}

	/**
	 * 获取总页数
	 */
	public int getPageTotal(String sql, int pageSize) {
		int total = 0;
		int count = this.getRecordCount(sql);
		total = count % pageSize == 0 ? (count / pageSize)
				: (count / pageSize + 1);

		if (total <= 0)
			total = 0;

		return total;
	}

	/**
	 *防止SQL注入的查询方法
	 */
	public ResultSet preQuery(String username, String password) {
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			PreparedStatement pastmt = conn.prepareStatement("select * from user where username like ? and password like ?");
			pastmt.setString(1, username);
			pastmt.setString(2, password);
			rs = pastmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 释放资源
	 */
	private void close() {
		try {
			if (null != conn) {
				DbConnectionPool.getinstance().release(conn);
				conn = null;
			}
			if (null != stat) {
				stat.close();
				stat = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
