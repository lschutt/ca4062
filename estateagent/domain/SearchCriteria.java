package com.estateagent.domain;

import java.io.Serializable;

public class SearchCriteria implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1609480059645990730L;
	
	private boolean all;
	
	private String id;
	
	public SearchCriteria(){}
	
	public SearchCriteria(boolean all, String id)
	{
		this.setAll(all);
		this.id  = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAll() {
		return all;
	}

	public void setAll(boolean all) {
		this.all = all;
	}

}