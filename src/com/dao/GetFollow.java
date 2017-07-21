package com.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.bean.User;
import com.util.DBUtil;


public class GetFollow {
	private static ResultSet rs = null;
	private static PreparedStatement prs = null;
	private static Connection conn= null;
	public  static List<User>  getFollowers(int uid){
		List<User> list = new ArrayList<User>();
		try{
			String sqlString="   select uid,username,headimg,gender,level from userinfo where uid in(  " +
		"  select  me from care where who = ?)	 ";
			conn=DBUtil.getConn();
			prs= conn.prepareStatement(sqlString);
			prs.setInt(1, uid);
		rs =	prs.executeQuery();
		User user = null;
		while(rs.next()){
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setUsernameString(rs.getString("username"));
			user.setGender(rs.getInt("gender")>0?"♂":"♀");
			user.setHeadimg(rs.getString("headimg"));
			user.setLevel(rs.getInt("level"));
			list.add(user);
		}
		return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public  static List<User>  getFollowing(int uid){
		List<User> list = new ArrayList<User>();
		try{
			String sqlString="   select  uid,username,headimg,gender,level"
				+ " from userinfo where uid in(  " 
				+"  select  who from care where me = ?)	 ";
			conn=DBUtil.getConn();
			prs= conn.prepareStatement(sqlString);
			prs.setInt(1, uid);
		rs =	prs.executeQuery();
		User user = null;
		while(rs.next()){
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setUsernameString(rs.getString("username"));
			user.setGender(rs.getInt("gender")>0?"♂":"♀");
			user.setHeadimg(rs.getString("headimg"));
			user.setLevel(rs.getInt("level"));
			list.add(user);
		}
		return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		List<User> list =getFollowers(1002);
		if(list!=null)
		{
			System.out.println(true);
		}
		for(User u:list){
			System.out.println(u.toString());
		}
	}
}
