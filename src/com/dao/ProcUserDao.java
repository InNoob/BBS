package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBUtil;

public class ProcUserDao {
	private Connection conn = null;
	private CallableStatement cst = null;
	
	
	/**
	 * 创建一个新用户
	 * @param password 密码
	 * @param email 邮箱
	 * @return
	 */
	public void insertUser(String email,String password){
		try {
			conn = DBUtil.getConn();
			String sql = "{call proc_createUser(?,?)}";
			cst = conn.prepareCall(sql);
			cst.setString(1, password);
			cst.setString(2, email);
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
	}
}
