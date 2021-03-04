package com.estateagent.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.estateagent.dao.Dao;
import com.estateagent.domain.Booking;
import com.estateagent.domain.SearchCriteria;

public class BookingDao implements Dao<Booking>
{
	private static List<Booking> allBookings = new ArrayList<>();
	
	public BookingDao(){}

	@Override
	public List<Booking> retrieve(SearchCriteria searchCriteria) 
	{
		if(!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			return allBookings.stream()
					          .filter((a) -> (a.getPropertyId().equals(searchCriteria.getId())))
					          .collect(Collectors.toList());
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			return allBookings;
		}
		
		else return null;
	}

	@Override
	public Booking insert(Booking object) 
	{
		if(object != null)
		{
			allBookings.add(object);
		}
		
		return object;
	}

	@Override
	public Booking update(Booking object) 
	{
		if(object != null)
		{
			Booking toBeReplaced =  
					
		    allBookings.stream()
			           .filter((a) -> (a.getPropertyId().equals(object.getPropertyId())))
			           .findAny()
			           .get();
			
			if(toBeReplaced != null)
			{
				int index = allBookings.indexOf(toBeReplaced);
				
				if(index != -1)
				{
					allBookings.add(index, object);
				}
			}
		}
	
		return null;
	}

	@Override
	public void delete(SearchCriteria searchCriteria) 
	{
		if(!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			List<Booking> newAllBookings = 
					
				   allBookings.stream()
					          .filter((a) -> (!(a.getPropertyId().equals(searchCriteria.getId()))))
					          .collect(Collectors.toList());
			
			allBookings = newAllBookings;
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			allBookings.clear();
		}
	}
}