package com.estateagent.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.estateagent.dao.Dao;
import com.estateagent.domain.Property;
import com.estateagent.domain.SearchCriteria;

public class PropertyDao implements Dao<Property>
{
	private static List<Property> allProperties = new ArrayList<>();
	
	public PropertyDao(){}
	
	static
	{		
		@SuppressWarnings("deprecation")
		Date d = new Date("Apr 21, 2017 9:43:12 AM"); // only making one property with default lastAvailableDate
		
		Property p1 = new Property("H1", "3", 2, 375.000, "99a",   "Sale", "12:00 - 17:00", d); // used here
		Property p2 = new Property("H2", "5", 3, 360.000, "8192b", "Sale", "12:00 - 17:00", null);
		Property p3 = new Property("H3", "3", 3, 500.000, "223c",  "Sale", "12:00 - 17:00", null);
		Property p4 = new Property("A1", "5", 2, 250.000, "23a",   "Sale", "12:00 - 17:00", null);
		Property p5 = new Property("A2", "7", 1, 150.000, "11n",   "Sale", "12:00 - 17:00", null);
		Property p6 = new Property("A3", "7", 2, 200.000, "193m",  "Sale", "12:00 - 17:00", null);
		
		allProperties.add(p1);
		allProperties.add(p2);
		allProperties.add(p3);
		allProperties.add(p4);
		allProperties.add(p5);
		allProperties.add(p6);
	}

	@Override
	public List<Property> retrieve(SearchCriteria searchCriteria) 
	{
		if(!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			return allProperties.stream()
					          .filter((a) -> (a.getId().equals(searchCriteria.getId())))
					          .collect(Collectors.toList());
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			return allProperties;
		}
		
		else return null;
	}
	
	public Property get(SearchCriteria searchCriteria) 
	{
		if(!!(searchCriteria.isAll()) && !(searchCriteria.getId().isEmpty()))
		{
			return allProperties.stream()
					          .filter((a) -> (a.getId().equals(searchCriteria.getId())))
					          .findAny().get();
		}
		
		else return null;
	}
	
	@Override
	public Property insert(Property object) 
	{
		if(object != null)
		{
			allProperties.add(object);
		}
		
		return object;
	}

	@Override
	public Property update(Property object) 
	{
		if(object != null)
		{
			Property toBeReplaced =  
					
		  allProperties.stream()
			           .filter((a) -> (a.getId().equals(object.getId())))
			           .findAny()
			           .get();
			
			if(toBeReplaced != null)
			{
				int index = allProperties.indexOf(toBeReplaced);
				
				if(index != -1)
				{
					allProperties.add(index, object);
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
			List<Property> newAllBookings = 
					
				 allProperties.stream()
					          .filter((a) -> (!(a.getId().equals(searchCriteria.getId()))))
					          .collect(Collectors.toList());
			
			allProperties = newAllBookings;
		}
		
		else if(searchCriteria.isAll() && searchCriteria.getId().isEmpty())
		{
			allProperties.clear();
		}
	}
}
