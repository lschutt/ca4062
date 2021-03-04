package com.estateagent.serviceImpl;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.estateagent.daoImpl.PropertyDao;
import com.estateagent.domain.Property;
import com.estateagent.domain.SearchCriteria;
import com.google.gson.Gson;

@Path("/property-service")
@ApplicationPath("/api")
public class PropertyService extends Application
{
	private PropertyDao propertyDao = new PropertyDao();
	
	@GET 
	@Path("/properties") 
	@Produces(MediaType.APPLICATION_JSON)
	public String retrieve(@QueryParam("all") boolean all, @QueryParam("id") String id) 
	{	
		List<Property> output = propertyDao.retrieve(new SearchCriteria(all, id));
		
		return new Gson().toJson(output); 
	}

	@POST 
	@Path("/properties") 
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String object) 
	{	
		Gson gson = new Gson();

		Property pojo = gson.fromJson(object, Property.class);

		Property output = propertyDao.insert(pojo);
		
		return new Gson().toJson(output); 
	}

	@PUT 
	@Path("/properties") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(String object) 
	{
		Gson gson = new Gson();

		Property pojo = gson.fromJson(object, Property.class);
		
        Property output = propertyDao.update(pojo);
		
		return new Gson().toJson(output); 
	}

	@DELETE
	@Path("/properties") 
	public void delete(@QueryParam("all") boolean all, @QueryParam("id") String id) 
	{
		propertyDao.delete(new SearchCriteria(all, id));
	}
}