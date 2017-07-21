package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bean.User;
import com.util.DBUtil;

public class GetUserDetails {
	private static ResultSet rs = null;
	private static PreparedStatement prs = null;
	private static Connection conn= null;
	
	public static User getUserDetails(int uid){
		try{
			String sql=" select*,(select count(*) from care where me=?) as carewho,(select count(*) from care where who=?)  as whocare,(select count(*) from favourite where uid = ?) as myfavourite,(select count(*) from topic where uid=?) as topiccount,(select sum(great) from topic where uid=?) as great from  userinfo where uid=?	";
			conn=DBUtil.getConn();
			prs=conn.prepareStatement(sql);
			prs.setInt(1, uid);
			prs.setInt(2, uid);
			prs.setInt(3, uid);
			prs.setInt(4, uid);
			prs.setInt(5, uid);
			prs.setInt(6, uid);
			rs = prs.executeQuery();
			rs.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date jtime = sdf.parse(rs.getString("jointime"));
			sdf= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			
			return new User(rs.getInt("uid"), rs.getString("username"), rs.getInt("gender")>0?"男":"女",
					rs.getString("birthday"), rs.getString("phone"), rs.getString("email"), rs.getString("headimg"),
					rs.getInt("level"), rs.getLong("mark"), rs.getString("whatup"),
					sdf.format(jtime).toString(), rs.getString("tag"), rs.getInt("myfavourite"), rs.getInt("carewho"),
					rs.getInt("whocare"), rs.getInt("topiccount"),rs.getInt("great"));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static User getOtherUserDetails(int me,int who){
		try{
			String sql=" select*,(select count(*) from care where me=?) as carewho,"
					+ " (select count(*) from care where who=?)  as whocare,"
					+ " (select count(*) from favourite where uid = ?) as myfavourite,"
					+ " (select count(*) from topic where uid=?) as topiccount,"
					+ " (select sum(great) from topic where uid=?) as great,"
					+ " (select count(1) from care where me =? and who=?) as state "
					+ " from  userinfo where uid=?	";
			conn=DBUtil.getConn();
			prs=conn.prepareStatement(sql);
			prs.setInt(1, me);
			prs.setInt(2, me);
			prs.setInt(3, me);
			prs.setInt(4, me);
			prs.setInt(5, me);
			prs.setInt(6, who);
			prs.setInt(7, me);
			prs.setInt(8, me);
			rs = prs.executeQuery();
			rs.next();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date jtime = sdf.parse(rs.getString("jointime"));
			sdf= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			User user =  new User(rs.getInt("uid"), rs.getString("username"), rs.getInt("gender")>0?"♂":"♀",
					rs.getString("birthday"), rs.getString("phone"), rs.getString("email"), rs.getString("headimg"),
					rs.getInt("level"), rs.getLong("mark"), rs.getString("whatup"),
					sdf.format(jtime).toString(), rs.getString("tag"), rs.getInt("myfavourite"), rs.getInt("carewho"),
					rs.getInt("whocare"), rs.getInt("topiccount"),rs.getInt("great"),rs.getInt("state"));
			return user;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		User user= getOtherUserDetails(1002, 1001);
		System.out.println(user.toString());
	}

}
