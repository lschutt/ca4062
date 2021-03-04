package com.estateagent.domain;

import java.io.Serializable;

public class PropertyBid  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737385974802677132L;

	private Property property;
	
	private String client;
	
	private double bid;
				
	public PropertyBid(){}
	
	public PropertyBid(Property property, String client, double bid)
	{
		this.property = property;
		this.client = client;
		this.bid = bid;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}
	
	@Override
	public String toString() {
		return "PropertyBid [property=" + property + ", client=" + client + ", bid=" + bid + "]";
	}
}