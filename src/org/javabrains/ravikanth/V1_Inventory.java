package org.javabrains.ravikanth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.javabrains.ravikanth.dao.MySqlDataSource;
import org.javabrains.ravikanth.dao.SearchByQuery;
import org.javabrains.ravikanth.utils.ToJSON;

@Path("/v2")
public class V1_Inventory {

	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnDBStatus() throws SQLException{
		Response response=null;
		
		SearchByQuery search=new SearchByQuery();
		JSONArray json=search.getAllUsers();
		response=Response.ok(json.toString()).build();
		return response;		
	}
	
	@GET
	@Path("/inventory/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnUserByName( @QueryParam("name") String name) throws SQLException {
		SearchByQuery search=new SearchByQuery();
		JSONArray json=search.getUserByName(name);
		
		return Response.ok(json.toString()).build();
	}
	
}
