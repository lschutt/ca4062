package com.estateagent.domain;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1842932720998578808L;
	
	private Date bookingDate;
	
	private String client;
	
	private String propertyId;
	
	public Booking(){}
	
	public Booking(Date bookingDate, String client, String propertyId)
	{
		this.bookingDate = bookingDate;
		this.client      = client;
		this.propertyId  = propertyId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public String toString() {
		return "Booking [bookingDate=" + bookingDate + ", client=" + client + ", propertyId=" + propertyId + "]";
	}
}
