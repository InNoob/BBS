package com.dao;
import java.util.*;
import com.bean.*;
import com.util.DBUtil;
import com.util.Pager;

import java.sql.*;

public class TopicDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 查询总页数
	 * @return 放回总页数
	 */
	public int getTotal(){
		try {
			conn = DBUtil.getConn();
			String sql = "select COUNT(1) from topic";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return 0;
	}
	
	/**
	 * 根据页码获取帖子
	 * @param pageNo	页码
	 * @return	当前页码的帖子
	 */
	public List<Topic> getTopicAll(int pageNo,int uid){
		List<Topic> list = new ArrayList<Topic>();
		try {
			conn = DBUtil.getConn();
			String sql = new StringBuilder(" select * from (")
					.append(" select ROW_NUMBER() over(order by t.stat desc) as no,")
					.append(" t.tid,t.bid,t.uid, ")
					.append("(select count(1) from care where me = ? and who=t.uid)as care,b.bname,")
					.append("u.userName,u.level,u.mark,u.headimg,")
					.append("t.title,t.topTime,t.stat,count(1)-1 as rCount,")
					.append("MAX(r.rectime) as newTime from topic as t inner join ")
					.append("recive as r on t.tid = r.tid inner join userinfo as u on ")
					.append("t.uid=u.uid ")
					.append("inner join block as b on t.bid = b.bid ")
					.append("group by t.tid,t.bid,t.uid,t.title,t.toptime,t.stat,")
					.append("u.username,u.level,u.mark,u.headimg,b.bname ")
					.append(") temp where no between ? and  ?").append(" order by toptime desc").toString();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, (pageNo-1)*Pager.getSize()+1);
			ps.setInt(3, pageNo*Pager.getSize());
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Topic(rs.getInt("tid"), rs.getInt("bid"), rs.getInt("uid"),
						rs.getString("userName"), rs.getInt("level"), rs.getLong("mark"), 
						rs.getString("headimg"), rs.getString("title"), rs.getString("topTime"),
						rs.getInt("stat"), rs.getInt("rCount"),rs.getString("newTime"),rs.getString("bname"),rs.getInt("care")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	public List<Topic> getTopicBlock(int pageNo,int uid,int bid){
		List<Topic> list = new ArrayList<Topic>();
		try {
			conn = DBUtil.getConn();
			String sql = new StringBuilder(" select * from (")
					.append(" select ROW_NUMBER() over(order by t.stat desc) as no,")
					.append(" t.tid,t.bid,t.uid, ")
					.append("(select count(1) from care where me = ? and who=t.uid)as care,b.bname,")
					.append("u.userName,u.level,u.mark,u.headimg,")
					.append("t.title,t.topTime,t.stat,count(1)-1 as rCount,")
					.append("MAX(r.rectime) as newTime from topic as t inner join ")
					.append("recive as r on t.tid = r.tid inner join userinfo as u on ")
					.append("t.uid=u.uid ")
					.append("inner join block as b on t.bid = b.bid ")
					.append("group by t.tid,t.bid,t.uid,t.title,t.toptime,t.stat,")
					.append("u.username,u.level,u.mark,u.headimg,b.bname ")
					.append(") temp where  no between ? and  ? and bid = ?").append(" order by toptime desc").toString();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, (pageNo-1)*Pager.getSize()+1);
			ps.setInt(3, pageNo*Pager.getSize());
			ps.setInt(4, bid);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Topic(rs.getInt("tid"), rs.getInt("bid"), rs.getInt("uid"),
						rs.getString("userName"), rs.getInt("level"), rs.getLong("mark"), 
						rs.getString("headimg"), rs.getString("title"), rs.getString("topTime"),
						rs.getInt("stat"), rs.getInt("rCount"),rs.getString("newTime"),rs.getString("bname"),rs.getInt("care")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 查询帖子详情
	 * @param tid
	 * @return 放回帖子详情的对象
	 */
	public TopicInfo getTopicInfo(int tid){
		TopicInfo tInfo = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select top 1 r.rid,r.tid,t.bid,r.uid,t.title,r.content,r.recTime,r.great,"
					+ " u.headimg,u.userName, (select COUNT(1)-1 from recive where tid = ?) as rcount,"
					+ " t.viewer as flowCount from recive r inner join topic t on r.tid = t.tid inner join"
					+ " userinfo u on u.uid = r.uid where r.tid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setInt(2, tid);
			rs = ps.executeQuery();
			if(rs.next()){
				tInfo = new TopicInfo(rs.getInt("rid"),rs.getInt("tid"),rs.getInt("bid"),rs.getInt("uid"),rs.getString("title"),rs.getString("content"),rs.getString("recTime"),rs.getInt("great"),rs.getString("headimg"),rs.getString("userName"),rs.getInt("rcount"),rs.getInt("flowCount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return tInfo;
	}
	
	public boolean addFlow(int tid){
		try {
			conn = DBUtil.getConn();
			String sql = "update topic set viewer += 1 where tid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			if(ps.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
