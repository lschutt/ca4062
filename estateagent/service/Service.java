package com.estateagent.service;

import java.util.List;

import com.estateagent.domain.SearchCriteria;

public interface Service<T> 
{
	public List<T> retrieve(SearchCriteria searchCriteria);
	
	public void insert(T object);
	
	public T update(T object);
	
	public void delete(SearchCriteria searchCriteria);
}
