package com.estateagent.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.estateagent.dao.Dao;
import com.estateagent.domain.PropertyBid;
import com.estateagent.domain.Response;
import com.estateagent.domain.SearchCriteria;

public class BidingDao implements Dao<PropertyBid>
{
	private static List<PropertyBid> allBidings = new ArrayList<>();
	
	public BidingDao(){}
	
	@Override
	public List<PropertyBid> retrieve(SearchCriteria searchCriteria) 
	{
		if(!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			return allBidings.stream()
					          .filter((a) -> (a.getProperty().getId().equals(searchCriteria.getId())))
					          .collect(Collectors.toList());
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			return allBidings;
		}
		
		else return null;
	}

	public Response protectedInsert(PropertyBid object) 
	{
		Response response = new Response();
		
		if(object != null && object.getProperty().getLastAvailableDate() != null)
		{ 
			if((object.getProperty().getLastAvailableDate()).after(new Date()) && !(object.getProperty().getCategory().equals("Sold"))) // still time left to bid
			{
				if(object.getBid() >= object.getProperty().getPrice())
				{
					object.getProperty().setCategory("Sold");
					allBidings.add(object);
					response.setMessage("Bid Accepted - You are the buyer!");
				}
				
				else if(!(isHighest(object.getBid())))
				{
					response.setMessage("Enter a counter offer - You are not the highest bidder!");
				}
				
				else if(object.getBid() < object.getProperty().getPrice() && !(object.getBid() <= 0))
				{
					allBidings.add(object);
					response.setMessage("Bid Accepted");
				}
			}
			
			else return response;
		}
		
		else if(object != null && !(object.getProperty().getCategory().equals("Sold")))
		{
			if(object.getBid() >= object.getProperty().getPrice())
			{
				object.getProperty().setCategory("Sold");
				allBidings.add(object);
				response.setMessage("Bid Accepted - You are the buyer!");
			}
			
			else if(!(isHighest(object.getBid())))
			{
				response.setMessage("Enter a counter offer - You are not the highest bidder!");
			}
			
			else if(object.getBid() < object.getProperty().getPrice() && !(object.getBid() <= 0))
			{
				allBidings.add(object);
				response.setMessage("Bid Accepted");
			}
		}
		
		return response;		
	}

	@Override
	public void delete(SearchCriteria searchCriteria) 
	{
		if(!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			List<PropertyBid> newAllBookings = 
					
					allBidings.stream()
					          .filter((a) -> (!(a.getProperty().getId().equals(searchCriteria.getId()))))
					          .collect(Collectors.toList());
			
			allBidings = newAllBookings;
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			allBidings.clear();
		}
	}
	
	private boolean isHighest(double bid)
	{
		boolean output = allBidings.stream()
					         .anyMatch((p) -> (p.getBid() > bid));
	
		return output;
	}

	// not used 
	@Override
	public PropertyBid insert(PropertyBid object) 
	{
		return null;
	}

	// not used
	@Override
	public PropertyBid update(PropertyBid object) 
	{
		return null;
	}
}