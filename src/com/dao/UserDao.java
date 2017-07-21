package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.util.DBUtil;

public class UserDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 根据用户信息登陆
	 * @param email	邮箱
	 * @param pass	密码
	 * @return	放回用户对象
	 */
	public User checkEmailLogin(String email,String pass){
		User user = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select uid from userinfo where email = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();	
			if(rs.next()){
				return GetUserDetails.getUserDetails(rs.getInt("uid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return user;
	}
	
	/**
	 * 查询用户名是否存在
	 * @param name	用户名
	 * @return
	 */
	public boolean checkRegisterEmail(String email){
		try {
			conn = DBUtil.getConn();
			String sql = "select 1 from userinfo where email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,email);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return false;
	}
	
	
	public boolean changeHeadimg(User user,String file){
		try {
			this.conn = DBUtil.getConn();
			String sqlcmd = "update userinfo set headimg=? where uid = ?";
			this.ps = conn.prepareStatement(sqlcmd);
			ps.setString(1,"resource/head/"+file);
			ps.setInt(2, user.getUid());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return false;
	}
	
	
}
