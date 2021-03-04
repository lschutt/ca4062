package com.estateagent.serviceImpl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

import com.estateagent.daoImpl.BookingDao;
import com.estateagent.domain.Booking;
import com.estateagent.domain.SearchCriteria;
import com.google.gson.Gson;

@Path("/booking-service")
@ApplicationPath("/api")
public class BookingService extends Application
{
	private BookingDao bookingDao = new BookingDao();
	Lock lock = new ReentrantLock();

	@GET 
	@Path("/bookings")
	@Produces(MediaType.APPLICATION_JSON)
	public String retrieve(@QueryParam("all") boolean all, @QueryParam("id") String id) 
	{
		List<Booking> output =  bookingDao.retrieve(new SearchCriteria(all, id));
		
		return new Gson().toJson(output); 
	}

	@POST 
	@Path("/bookings") 
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String object) 
	{
		lock.lock();
		
		Gson gson = new Gson();

		Booking pojo = gson.fromJson(object, Booking.class);
		
		Booking output = null;
		
		try
		{
			output = bookingDao.insert(pojo);
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

	@PUT 
	@Path("/bookings") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String object) 
	{
		lock.lock();
		
		Gson gson = new Gson();

		Booking pojo = gson.fromJson(object, Booking.class);
		
		Booking output = null;
		
		try
		{
			output = bookingDao.update(pojo);
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

	@DELETE 
	@Path("/bookings") 
	public void delete(@QueryParam("all") boolean all, @QueryParam("id") String id) 
	{
		bookingDao.delete(new SearchCriteria(all, id));
	}	
}