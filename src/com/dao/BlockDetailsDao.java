package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.Block;
import com.util.DBUtil;

public class BlockDetailsDao {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection conn = null;

	
	public final ArrayList<Block> getBlockDetails(){
		ArrayList<Block> list = new ArrayList<Block>();
		try {
			this.conn = DBUtil.getConn();
			String sqlcmd = "select b.bid,b.bname,count(t.tid) as tcount from block as b inner join topic as t on b.bid = t.bid group by b.bname,b.bid";
			this.ps = conn.prepareStatement(sqlcmd);
			this.rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Block(rs.getInt("bid"),rs.getString("bname"),rs.getInt("tcount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
