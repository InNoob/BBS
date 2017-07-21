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
			if(this.checkCare(me, who)){
				return true;
			}
			this.conn = DBUtil.getConn();
			String sqlcmd = "insert into care values(?,?,null)";
			ps = conn.prepareStatement(sqlcmd);
			ps.setInt(1, me);
			ps.setInt(2, who);
			return !ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeAll(null, ps, conn);
		}
	}
	
	public final boolean unCare(int me,int who) {
		try {			
			if(!this.checkCare(me, who)){
				return true;
			}
			this.conn = DBUtil.getConn();
			String sqlcmd = "delete from care where me=? and who = ?";
			ps = conn.prepareStatement(sqlcmd);
			ps.setInt(1, me);
			ps.setInt(2, who);
			return !ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeAll(null, ps, conn);
		}
	}
	
	public final boolean checkCare(int me,int who) {
		try {
			this.conn = DBUtil.getConn();
			String sqlcmd = "select 1 from care where me = ? and who = ?";
			ps = conn.prepareStatement(sqlcmd);
			ps.setInt(1, me);
			ps.setInt(2, who);
			rs=ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
	}
}
