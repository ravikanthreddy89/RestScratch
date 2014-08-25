package org.javabrains.ravikanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.javabrains.ravikanth.utils.ToJSON;


public class SearchByQuery extends MySqlDataSource {

	/*
	 * This guy need to return the results of database queries.
	 */
	
	public JSONArray getAllUsers() throws SQLException {
		PreparedStatement stmt=null;
		Connection con=null;
		JSONArray ret=null;
		
		try{
			con=getDataSource().getConnection();
			stmt=con.prepareStatement("select id, name, age, grade from test.users");
			ResultSet resultSet=stmt.executeQuery();
			
			ret=ToJSON.converter(resultSet);
			stmt.close();
		}
		catch(SQLException sql){
			sql.printStackTrace();
			return ret;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ret;
		}
		
		finally{
			if(con!=null) con.close(); 
		}
		return ret;
	}
	
	
	public JSONArray getUserByName(String name) throws SQLException{
		PreparedStatement stmt=null;
		Connection con=null;
		JSONArray json=null;
		
		try{
			con=getDataSource().getConnection();
			stmt=con.prepareStatement("select id, name, age, grade from test.users where name = ?");
			stmt.setString(1, name);
			json=ToJSON.converter(stmt.executeQuery());
			
			stmt.close();
			return json;
		}catch(SQLException | JSONException sql){
			sql.printStackTrace();
		}		
		finally{
			if(con!=null) con.close();
		}
		
		return json;
		
	}
}
