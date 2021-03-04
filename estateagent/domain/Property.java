package com.estateagent.domain;

import java.io.Serializable;
import java.util.Date;

public class Property implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3012257765369713250L;
	
	private String type;
	private String district;
	private int    bedrooms;
	private double price;
	private String id;
	private String category;
	private String viewingTimes;
	private Date addedDate;
	private Date lastModifiedDate;
	private Date lastAvailableDate;

	public Property()
	{
	  this.addedDate        = new Date();
	  this.lastModifiedDate = new Date();
	}

	public Property(String type, String district, int bedrooms, double price, String id, String category, String viewingTimes, Date localDateTime)
	{
	  this.type     = type;
	  this.district = district;
	  this.bedrooms = bedrooms;
	  this.price    = price;
	  this.id       = id;
	  this.category = category;
	  this.viewingTimes      = viewingTimes;
	  this.addedDate         = new Date();
	  this.lastModifiedDate  = new Date();
	  this.lastAvailableDate = localDateTime;
	}

	public String getType()
	{
	  return this.type;
    }

	public void setType(String type)
	{
	  this.type = type;
	}

	public String getDistrict()
	{
	  return this.district;
	}

	public void setDistrict(String district)
	{
	  this.district = district;
	}

	public int getBedrooms()
	{
	  return this.bedrooms;
	}

	public void setBedrooms(int bedrooms)
	{
	  this.bedrooms = bedrooms;
	}

	public double getPrice()
	{
	  return this.price;
	}

	public void setPrice(double price)
	{
	  this.price = price;
	}

	public Date getAddedDate()
	{
	  return this.addedDate;
	}

	public void setAddedDate(Date addedDate)
	{
	  this.addedDate = addedDate;
	}

	public Date getLastModifiedDate()
	{
	  return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate)
	{
	  this.lastModifiedDate = lastModifiedDate;
	}

	public Date getLastAvailableDate() 
	{
		return lastAvailableDate;
	}

	public void setLastAvailableDate(Date lastAvailableDate) 
	{
		this.lastAvailableDate = lastAvailableDate;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getViewingTimes() {
		return viewingTimes;
	}

	public void setViewingTimes(String viewingTimes) {
		this.viewingTimes = viewingTimes;
	}

	@Override
	public String toString() {
		return "Property [type=" + type + ", district=" + district + ", bedrooms=" + bedrooms + ", price=" + price
				+ ", id=" + id + ", category=" + category + ", viewingTimes=" + viewingTimes + ", addedDate="
				+ addedDate + ", lastModifiedDate=" + lastModifiedDate + ", lastAvailableDate=" + lastAvailableDate
				+ "]";
	}
}