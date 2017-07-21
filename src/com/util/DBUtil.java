package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=bbsdb";
	private static final String USER="sa";
	private static final String PWD="Jb991015";

	static{
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(URL,USER,PWD);
	}

	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(null!=rs)
				rs.close();
			if(null!=ps)
				ps.close();
			if(null!=conn)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(null!=rs)
				rs.close();
			if(null!=stmt)
				stmt.close();
			if(null!=conn)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
