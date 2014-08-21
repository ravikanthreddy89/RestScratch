package org.javabrains.ravikanth.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlDataSource {
	
	private static DataSource dataSource=null;
	private static Context context=null;
	
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
}
