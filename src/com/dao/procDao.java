package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBUtil;

public class procDao {
	private Connection conn = null;
	private CallableStatement cst = null;
	
	public boolean insertRecive(String content){
		
		try {
			conn = DBUtil.getConn();
			String sql = " {call proc_creatRecive(?,?,?,?,?,?,?)} ";
			
			cst = conn.prepareCall(sql);
			
			cst.setInt(1, 1);
			cst.setInt(2, 1);
			cst.setInt(3, 1000);			
			cst.setInt(4, 1002);
			cst.setString(5, content);
			cst.setString(6, null);
			cst.setString(7, null);
			
			return cst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
		
		return false;
	}
	
	public void newTopic(int bid,int uid,String title,String content){
		try {
			conn = DBUtil.getConn();
			String sql = "{call proc_creatTopic(?,?,?,?,?,?)} ";
			cst = conn.prepareCall(sql);
			cst.setInt(1, bid);
			cst.setInt(2, uid);
			cst.setString(3,title);
			cst.setString(4, content);
			cst.setString(5,null);
			cst.setString(6,null);
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
	}
	
	public void newRecive(int bid,int tid,int sender,int revicer,String content){
		try {
			conn = DBUtil.getConn();
			String sql = "{call proc_creatRecive(?,?,?,?,?,?,?)} ";
			cst = conn.prepareCall(sql);
			cst.setInt(1, bid);
			cst.setInt(2, tid);
			cst.setInt(3, sender);
			cst.setInt(4, revicer);
			cst.setString(5, content);
			cst.setString(6,null);
			cst.setString(7,null);
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
	}
	
	public void newEvalut(int bid,int tid,int rid,int sender,int reciver,String content){
		try {
			conn = DBUtil.getConn();
			String sql = "{call proc_creatEvaluat(?,?,?,?,?,?,?,?)} ";
			cst = conn.prepareCall(sql);
			cst.setInt(1, bid);
			cst.setInt(2, tid);
			cst.setInt(3, rid);
			cst.setInt(4, sender);
			cst.setInt(5, reciver);
			cst.setString(6, content);
			cst.setString(7, null);
			cst.setString(8, null);
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
	}
	
	public void newRevaluat(int bid,int tid,int rid,int beid,int sender,int reciver,String content){
		try {
			conn = DBUtil.getConn();
			String sql = "{call proc_creatRevaluat(?,?,?,?,?,?,?,?,?)} ";
			cst = conn.prepareCall(sql);
			cst.setInt(1, bid);
			cst.setInt(2, tid);
			cst.setInt(3, rid);
			cst.setInt(4, beid);
			cst.setInt(5, sender);
			cst.setInt(6, reciver);
			cst.setString(7, content);
			cst.setString(8, null);
			cst.setString(9, null);
			cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(null, cst, conn);
		}
	}
}
