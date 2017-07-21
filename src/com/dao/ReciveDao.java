package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Evaluat;
import com.bean.Recive;
import com.util.DBUtil;

public class ReciveDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private ResultSet rs1 = null;
	
	public List<Recive> SelectReciveById(int tid){
		List<Recive> list = new ArrayList<Recive>();
		try {
			conn = DBUtil.getConn();
			
			String sql = "select r.*,u.username,u.headimg from recive r inner join userinfo u on r.uid = u.uid where tid =? and rid!=(select top 1 rid from recive where tid = ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setInt(2, tid);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Recive(rs.getInt("rid"),rs.getInt("tid"),rs.getInt("uid"),
						rs.getString("username"),rs.getString("content"),rs.getString("recTime"),
						rs.getString("great"),rs.getString("headimg"),SelectEvaluatById(rs.getInt("rid"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
	}
	
	public List<Evaluat> SelectEvaluatById(int rid){
		List<Evaluat> list = new ArrayList<Evaluat>();
		try {
			conn = DBUtil.getConn();
			
			String sql = " select e.eid,e.uid,u.username,e.rid,e.content,"
					+ " (select username from userinfo where uid ="
					+ " (select beuid from revaluat where meid = e.eid)) as beuid"
					+ " from evaluat e inner join userinfo u on e.uid = u.uid where rid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			rs1 = ps.executeQuery();
			while(rs1.next()){				
				list.add(new Evaluat(rs1.getInt("eid"),rs1.getInt("rid"),rs1.getInt("uid"),rs1.getString("beuid"),rs1.getString("content"),rs1.getString("username")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs1, ps, conn);
		}
		return list;
	}
	
	
}
