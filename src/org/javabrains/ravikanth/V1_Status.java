package org.javabrains.ravikanth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.javabrains.ravikanth.dao.MySqlDataSource;
import org.javabrains.ravikanth.utils.ToJSON;

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

}

