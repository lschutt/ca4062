package com.estateagent.domain;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4837607896984302019L;

	private String message;
		
	private List<PropertyBid> bid;
	
	public Response(){}
	
	public Response(List<PropertyBid> bid, String message)
	{
		this.bid     = bid;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PropertyBid> getBid() {
		return bid;
	}

	public void setBid(List<PropertyBid> bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", bid=" + bid + "]";
	}
}
