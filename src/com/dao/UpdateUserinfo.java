package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import com.bean.User;
import com.util.DBUtil;

public class UpdateUserinfo {
//	private static ResultSet rs = null;
	private static PreparedStatement prs = null;
	private static Connection conn= null;
	public static boolean updateuserinfo(User user){
		try{
			String sql= " update userinfo set username=?,gender=?,birthday=?,phone=?,whatup=?,tag=? where uid= ?  ";
			conn=DBUtil.getConn();
			prs=conn.prepareStatement(sql);
			prs.setString(1, user.getUsername());
			prs.setInt(2, user.getGender()=="男"?1:0);
			prs.setString(3, user.getBirthday());
			prs.setString(4, user.getPhone());
			prs.setString(5, user.getWhatup());
			prs.setString(6, user.getTag());
			prs.setInt(7, user.getUid());
			if(prs.executeUpdate()>0) return true;
			else return false;
		}catch(Exception e){
			return false;
		}
	}
	public static void main(String[] args) {
		User user = new User();
		user.setUid(1002);
		user.setUsernameString("123");
		user.setGender("男");
		user.setBirthday("1988-02-21 00:00:00.0");
		user.setPhone("87654321");
		user.setWhatup("hello world");
		user.setTag("666");
		System.out.println(updateuserinfo(user));
	}

}
