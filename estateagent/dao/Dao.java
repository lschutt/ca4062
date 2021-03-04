package com.estateagent.dao;

import java.util.List;

import com.estateagent.domain.SearchCriteria;

public interface Dao<T> 
{
	public List<T> retrieve(SearchCriteria searchCriteria);
	
	public T insert(T object);
	
	public T update(T object);
	
	public void delete(SearchCriteria searchCriteria);
}