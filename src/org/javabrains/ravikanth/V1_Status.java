package org.javabrains.ravikanth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javabrains.ravikanth.dao.MySqlDataSource;

@Path("/v1/status")
public class V1_Status {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Rest Service.<p>";
	}
	
	
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version : 1.1<p>";
	}

	@GET
	@Path("/database")
	@Produces(MediaType.TEXT_HTML)
	public String returnDBStatus() throws SQLException{
		PreparedStatement stmt=null;
		Connection con=null;
		ResultSet result=null;
		String query="show databases";
		String ret=null;
		
		try{
			con=MySqlDataSource.getDataSource().getConnection();
			stmt=con.prepareStatement(query);
			result=stmt.executeQuery();
			
			while(result.next()){
				ret=ret+"<p>"+result.getString(1)+"</p>";
			}
			//ret=result.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			stmt.close();
			con.close();
		}		
		return ret;		
	}
}

