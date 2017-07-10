package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBUtil;

public final class TakeCareDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	
	public final boolean takeCare(int me,int who) {
		try {
			this.conn = DBUtil.getConnection();
			String sqlcmd = "insert into care values(?,?,null)";
			ps = conn.prepareStatement(sqlcmd);
			ps.setInt(1, me);
			ps.setInt(2, who);
			return !ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
