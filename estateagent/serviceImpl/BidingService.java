package com.estateagent.serviceImpl;


import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.estateagent.daoImpl.BidingDao;
import com.estateagent.domain.CounterOffer;
import com.estateagent.domain.PropertyBid;
import com.estateagent.domain.Response;
import com.estateagent.domain.SearchCriteria;
import com.google.gson.Gson;

@Path("/biding-service")
@ApplicationPath("/api")
public class BidingService extends Application
{
	private BidingDao bidingDao = new BidingDao();
	private final Lock lock = new ReentrantLock();
	
	@GET 
	@Path("/bidings") 
	@Produces(MediaType.APPLICATION_JSON)
	public String retrieve(@QueryParam("all") boolean all, @QueryParam("id") String id) 
	{
		List<PropertyBid> output =  bidingDao.retrieve(new SearchCriteria(all, id));
		
		return new Gson().toJson(output); 
	}

	@POST
	@Path("/bidings") 
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String object) 
	{
		lock.lock();
		
		Gson gson = new Gson();

		PropertyBid pojo = gson.fromJson(object, PropertyBid.class);
		
		Response output = null;
		
		try
		{	
			output = bidingDao.protectedInsert(pojo);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			lock.unlock();
		}	
		
		return new Gson().toJson(output); 
	}
	
	@POST
	@Path("/bidings/counter") 
	@Produces(MediaType.APPLICATION_JSON)
	public String counterOffer(String counter)
	{		
		String [] tokens = counter.split(",");
		
		String id = tokens[0];
		
		String client = tokens[1];
		
		String offer = tokens[2];
		
		double value = Double.parseDouble(offer);

        List<PropertyBid> bid = bidingDao.retrieve(new SearchCriteria(false, id)); // find "property" - as its all we'll use for this
        
        PropertyBid newBid = new PropertyBid(bid.get(0).getProperty(), client, value);
                
        bidingDao.protectedInsert(newBid);
        
		CounterOffer newOffer = new CounterOffer(bid, value);
		
		return new Gson().toJson(newOffer); 
	}
}