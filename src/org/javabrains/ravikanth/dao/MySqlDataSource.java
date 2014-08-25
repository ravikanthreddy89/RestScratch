package org.javabrains.ravikanth.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDataSource {
	
	private static DataSource dataSource=null;
	private static Context context=null;
	private static Connection con=null;
	
	public static DataSource getDataSource(){
		
		System.out.println("Hello1");
		if(dataSource!=null) return dataSource;
		try{			
			if(context==null){
				context=new InitialContext();
			}			
			dataSource=(DataSource)context.lookup("jdbc/MySql");
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataSource;		
	}
	
	public static Connection getConnection() throws SQLException{
		if(con!=null) return con;
		con=getDataSource().getConnection();
		return con;
	}
}
