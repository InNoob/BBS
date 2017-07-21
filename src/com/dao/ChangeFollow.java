package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import com.util.DBUtil;

public class ChangeFollow {
//	private static ResultSet rs = null;
	private static PreparedStatement prs = null;
	private static Connection conn= null;
	
	public  static boolean  insertFollowing(int me,int who){
		try{
			conn=DBUtil.getConn();
			String sql= " insert into care values(?,?,?) ";
			prs=conn.prepareStatement(sql);
			prs.setInt(1, me);
			prs.setInt(2, who);
			prs.setString(3, null);
			return prs.executeUpdate()>0;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
