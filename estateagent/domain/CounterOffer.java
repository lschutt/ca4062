package com.estateagent.domain;

import java.io.Serializable;
import java.util.List;


public class CounterOffer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4778563798389288906L;
	
	private List<PropertyBid> bid;
	
	private double offer;

	public CounterOffer(){}
	
	public CounterOffer(List<PropertyBid> bid, double offer)
	{
		this.bid   = bid;
		this.offer = offer;
	}
	
	public List<PropertyBid> getBid() {
		return bid;
	}

	public void setBid(List<PropertyBid> bid) {
		this.bid = bid;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "CounterOffer [bid=" + bid + ", offer=" + offer + "]";
	}

}